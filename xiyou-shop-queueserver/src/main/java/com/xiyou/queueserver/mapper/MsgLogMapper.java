package com.xiyou.queueserver.mapper;

import com.xiyou.common.model.MessageLog;

public interface MsgLogMapper {

    /**
     * 添加一条日志信息
     * @param messageLog
     */
    public void insertMessageLog(MessageLog messageLog);

    /**
     * 更新一条日志信息
     * @param messageLog
     */
    public void updateMessageLog(MessageLog messageLog);

}
