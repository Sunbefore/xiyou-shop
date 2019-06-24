package com.xiyou.common.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2018/9/29.
 */

@Data
public class MessageLog {
    // 主键
    private int id;
    // 业务类型：比如：order
    private String ywtype;
    // 业务id
    private int ywid;
    // 业务消息实体
    private String ywmessage;
    // 业务消息状态： 1未发送，2，已发送，3发送失败 4,消费者未接受 5，消费成功，6消费失败
    private int ywmessagestatus;
    // 第一次发送的时间
    private Date msgcreatedate;
    // 更新时间
    private Date msgupdatedate;
}
