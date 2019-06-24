package com.xiyou.queueserver.dao;

import com.xiyou.common.model.MessageLog;
import com.xiyou.queueserver.mapper.MsgLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDao {

    @Autowired
    private MsgLogMapper msgLogMapper;

    /**
     * 添加一条日志信息
     * @param messageLog
     */
    public void insertMessageLog(MessageLog messageLog){
        msgLogMapper.insertMessageLog(messageLog);
    }

    /**
     * 更新一条日志信息
     * @param messageLog
     */
    public void updateMessageLog(MessageLog messageLog){
        msgLogMapper.updateMessageLog(messageLog);
    }
}
