package com.xiyou.common.vo;

import com.xiyou.common.model.Order;
import com.xiyou.common.model.OrderDetail;
import lombok.Data;

import java.io.Serializable;

/**
 * 因为订单服务需要有Order类和OrderDetail类，但是Post请求的时候Feign需要加上@RequestBody，但是我们最多只能在参数上加上一个@RequestBody，所以进行封装
 */
@Data
public class OrderAll implements Serializable{
    private Order order;
    private OrderDetail orderDetail;
}
