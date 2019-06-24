package com.xiyou.queueserver.service;

import com.xiyou.common.model.MessageLog;
import com.xiyou.queueserver.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageLogService {

    @Autowired
    private MessageDao messageDao;

    /**
     * 添加一条日志信息
     * @param messageLog
     */
    public void insertMessageLog(MessageLog messageLog){
        messageDao.insertMessageLog(messageLog);
    }

    /**
     * 更新一条日志信息
     * @param messageLog
     */
    public void updateMessageLog(MessageLog messageLog){
        messageDao.updateMessageLog(messageLog);
    }

}
