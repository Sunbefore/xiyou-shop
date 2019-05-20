package com.xiyou.payservice.service;

public interface PayService {
    /**
     * 根据流水号支付金额
     * @param tradenumber 流水号
     * @param amount 交付金额
     * @return 0表示支付成功 1表示支付不成功
     */
    public int payWithPayAmount(String tradenumber, int amount);
}
