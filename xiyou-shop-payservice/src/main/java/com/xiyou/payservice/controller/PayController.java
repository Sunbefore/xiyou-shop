package com.xiyou.payservice.controller;

import com.xiyou.payservice.service.impl.WeiXinPayService;
import com.xiyou.payservice.service.impl.YinLianPayService;
import com.xiyou.payservice.service.impl.ZhiFuBaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayController {

    @Autowired
    private WeiXinPayService weiXinPayService;

    @Autowired
    private ZhiFuBaoPayService zhiFuBaoPayService;

    @Autowired
    private YinLianPayService yinLianPayService;

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
}
