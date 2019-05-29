package com.xiyou.payservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiyou.common.model.Order;
import com.xiyou.payservice.service.OrderService;
import com.xiyou.payservice.service.impl.WeiXinPayService;
import com.xiyou.payservice.service.impl.YinLianPayService;
import com.xiyou.payservice.service.impl.ZhiFuBaoPayService;
import com.xiyou.payservice.service.weixin.PayRequest;
import com.xiyou.payservice.service.weixin.PayResponse;
import com.xiyou.payservice.service.weixin.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

// 日志注解
@Slf4j
@Controller
public class PayController {

    @Autowired
    private WeiXinPayService weiXinPayService;

    @Autowired
    private ZhiFuBaoPayService zhiFuBaoPayService;

    @Autowired
    private YinLianPayService yinLianPayService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;
    /**
     *
     * @param tradenumber
     * @param amount
     * @param payType 1 微信支付 2 银联卡支付 3 支付宝支付
     * @return 1 表示支付成功 2 表示支付失败
     */
    @RequestMapping("/payWithAmount")
    public int payWithAmount(String tradenumber, int amount, String payType){
        // 默认是支付失败
        int payResult = 2;
        switch (payType){
            case "1" :
                payResult = weiXinPayService.payWithPayAmount(tradenumber, amount);
                break;
            case "2" :
                payResult = yinLianPayService.payWithPayAmount(tradenumber, amount);
                break;
            case "3" :
                payResult = zhiFuBaoPayService.payWithPayAmount(tradenumber, amount);
                break;
        }
        return payResult;
    }

    @RequestMapping("/auth")
    public void auth(@RequestParam("code") String code, @RequestParam("orderId") Integer orderId){
        log.info("进入auth方法...");
        log.info("code={}", code);
        // 通过下面的url在微信端访问，这时候就会回调该方法，将拿到的code带入 进行访问
        // url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4c3f858dd56910ae&redirect_uri=http://xiyoushop.natapp1.cc/auth?orderId=2&response_type=code&scope=snsapi_base#wechat_redirect";
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx4c3f858dd56910ae&secret=45bbf13f7c8569af381328a8154ea66d&code=" + code + "&grant_type=authorization_code";
        // 利用restTemplate远程调用（ribbon）指定的url，得到相应
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        // 将字符串变为jsonObject对象
        JSONObject object = JSONObject.parseObject(response);
        // 获得openid，根据openid进行支付功能
        String openid = object.getString("openid");
        log.info("===={}", openid);
        /**
         * 因为我拿不到商户id，所以这里我就模拟支付过程得了
         */
        // 根据orderId拿到Order对象，拿到订单的相关信息
        Order order = orderService.findOrderById(orderId);
        System.out.println(order);
        log.info(".............");
        log.info("此时正在支付。。。。。。。。。");
        log.info(".............");
        log.info("订单{}支付成功！！！！！", order);
        // 订单成功支付后需要进行order的状态更新，包括支付方式，支付状态，支付时间
        // 时间自己赋值，不需要传递
        // 这里的参数的意思是order的id， 支付的类型(1表示微信支付)， 支付的状态 2表示已经支付
        orderService.updateOrderById(orderId, 1, 2);
    }
}
