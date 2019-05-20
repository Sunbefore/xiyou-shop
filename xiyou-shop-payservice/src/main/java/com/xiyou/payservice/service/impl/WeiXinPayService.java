package com.xiyou.payservice.service.impl;

import com.xiyou.payservice.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class WeiXinPayService implements PayService {

    /**
     * 根据流水号 交付金额
     * @param tradenumber 流水号
     * @param amount 交付金额
     * @return 0表示支付成功 1表示支付不成功
     */
    @Override
    public int payWithPayAmount(String tradenumber, int amount) {
        System.out.println("微信支付成功.....");
        // 0表示支付成功
        return 0;
    }
}
