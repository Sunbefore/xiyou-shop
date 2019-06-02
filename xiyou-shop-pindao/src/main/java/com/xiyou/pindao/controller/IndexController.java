package com.xiyou.pindao.controller;

import com.xiyou.common.model.*;
import com.xiyou.common.vo.OrderAll;
import com.xiyou.pindao.service.OrderService;
import com.xiyou.pindao.service.ProductService;
import com.xiyou.pindao.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 根据产品类型找到相关的产品
 */
@Controller
public class IndexController {
    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据productTypeId查询ProductType
     * @param model
     * @param productTypeId
     * @return
     */
    @GetMapping("/indexProduct/{productTypeId}")
    public String indexProduct(Model model, @PathVariable Integer productTypeId){
        // 查询出所有的产品类型
        List<ProductType> productTypeList = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", productTypeList);
        if(productTypeId == -1){
            // 如果不存在默认将第一个传递进来
            productTypeId = productTypeList.get(0).getId();
        }
        // 根据产品类型id 查询所有的产品
        List<Product> productList = productService.listProductOut(productTypeId);
        model.addAttribute("productList", productList);
        return "list";
    }


    /**
     * 根据关键词 查询product
     * @param keyWord
     * @return
     */
    @PostMapping("/searchProductOut")
    public String searchProductOut(String keyWord, Model model){
        List<Product> productList = productService.searchProductOut(keyWord);
        System.out.println("solr搜索结果：" + productList);
        model.addAttribute("productList", productList);
        return "list";
    }

    /**
     * 跳转到详情页
     */
    @GetMapping("/toProductDetail")
    public String toProductDetail(Model model, Integer productId, Integer productTypeId){
        List<ProductType> productTypeList = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", productTypeList);
        System.out.println(productTypeList);
        if(productTypeId == -1){
            productTypeId = productTypeList.get(0).getId();
        }
        Product product = productService.viewOutProduct(productId);
        model.addAttribute("product", product);
        ProductDetail productDetail = productService.findProductDetailByProductId(productId);
        model.addAttribute("productDetail", productDetail);
        return "productdetail";
    }

    /**
     * 根据商品id计算应该付款的总金额
     * @param model
     * @param productId
     * @param num
     * @return
     */
    @GetMapping(value = "/toBuy")
    public String toBuy(Model model, @RequestParam int productId, @RequestParam int num){
        List<ProductType> list = productTypeService.listAllProductType();
        model.addAttribute("producTypeList",list);
        Product product = productService.viewOutProduct(productId);
        model.addAttribute("product",product);
        double price = product.getProductprice();//商品价格
        double totalamount = price*num;//总金额
        model.addAttribute("totalamount",totalamount);
        model.addAttribute("num",num);
        return "insertOrder";
    }

    /**
     * 新增订单相关信息
     * @param model
     * @param req
     * @param num
     * @param productid
     * @param payamount
     * @param mechartid
     * @param consigneeadress
     * @param consigneename
     * @param consigneephone
     */
    @PostMapping("/insertOrder")
    public String insertOrder(Model model,
                            HttpServletRequest req,
                            int num,
                            int productid,
                            double payamount,
                            int mechartid,
                            String consigneeadress,
                            String consigneename,
                            String consigneephone){

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        // 若未登录，则跳转到登录页面
        if(user == null){
            return "login";
        }else {
            Order order = new Order();
            User userreal = (User)user;
            int userid = userreal.getId();
            order.setUserid(userid);
            order.setPayamount(payamount);
            order.setConsigneename(consigneename);
            order.setConsigneephone(consigneephone);
            order.setConsigneeadress(consigneeadress);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductid(productid);
            orderDetail.setMechartid(mechartid);
            orderDetail.setTradenum(num);

            OrderAll orderAll = new OrderAll();
            orderAll.setOrder(order);
            orderAll.setOrderDetail(orderDetail);
            int orderId = orderService.insertOutOrder(orderAll);
            model.addAttribute("orderId",orderId);
            return "payorder";
        }


    }


    /**
     * 支付服务，新增订单后，跳转到支付平台
     * @param model
     * @param req
     * @param orderId 订单id
     * @param payType 支付平台种类 1 微信 2 支付宝 3 银联
     * @return
     */
    @PostMapping("/payOrder")
    public String payOrder(Model model,
                           HttpServletRequest req,
                           int orderId,
                           int payType){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        // 如果用户没有登录让其进行登录操作
        if (user == null){
            return "login";
        }
        // 根据支付类别判断登录方式
        // 微信支付 payType是1
        if (1 == payType){
            String url =
                    "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4c3f858dd56910ae&redirect_uri=http://xiyoushop.natapp1.cc/auth?orderId="+ orderId +"&response_type=code&scope=snsapi_base#wechat_redirect";
            // 利用restTemplate进行远程的url访问，得到String类型
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("==================");
            System.out.println("response: " + response);
            System.out.println("==================");
            return "list";
        }
        System.out.println("==================");
        System.out.println("这里暂时不支持其他方式支付");
        System.out.println("==================");
        // 目前不太可能是null，null这里表示的是已经登录，用的别的方式进行支付
        return null;
    }

}
