package com.xiyou.payservice.service.impl;

import com.xiyou.payservice.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class YinLianPayService implements PayService{
    /**
     *
     * @param tradenumber 流水号
     * @param amount 交付金额
     * @return 0表示支付成功 1表示支付不成功
     */
    @Override
    public int payWithPayAmount(String tradenumber, int amount) {
        System.out.println("银联支付成功.....");
        return 0;
    }
}
