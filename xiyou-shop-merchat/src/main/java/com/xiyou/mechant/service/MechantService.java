package com.xiyou.mechant.service;

import com.xiyou.mechant.dao.MechantDao;
import com.xiyou.mechant.model.Mechant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechantService {

    @Autowired
    private MechantDao mechantDao;

    /**
     * 插入商家信息
     * 其中因为<selectKey/>的原因，让其自动生成的id可以赋值到形参当中
     * @param mechant
     */
    public void insertMechant(Mechant mechant){
        // 添加默认状态
        mechant.setAuditstatus(1);
        mechant.setSoldout(1);
        mechantDao.insertMechant(mechant);
    }

    /**
     * 更新商家的信息
     * @param mechant
     */
    public void updateMechant(Mechant mechant){
        mechant.setSoldout(1);
        mechantDao.updateMechant(mechant);
    }

    /**
     * 根据id查找商家的信息
     * @param id
     * @return
     */
    public Mechant findMechantById(int id){
        return mechantDao.findMechantById(id);
    }

    /**
     * 更新商家的状态，审核通过，提交成功还是审核不通过
     * @param
     */
    public void upateMechantStatus(int status, int id){
        Mechant mechant = new Mechant();
        mechant.setId(id);
        mechant.setAuditstatus(status);
        mechantDao.upateMechantStatus(mechant);
    }

    /**
     * 更新商家的经营状态是正常发售还是已经下架
     * @param
     */
    public void upateSoldout(int status,int id){
        Mechant mechant = new Mechant();
        mechant.setId(id);
        mechant.setSoldout(status);
        mechantDao.upateSoldout(mechant);
    }
}
