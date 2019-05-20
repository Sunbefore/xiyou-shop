package com.xiyou.mechant.dao;

import com.xiyou.mechant.mapper.MechantMapper;
import com.xiyou.mechant.model.Mechant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MechantDao {

    @Autowired
    private MechantMapper mechantMapper;

    /**
     * 插入商家信息
     * 其中因为<selectKey/>的原因，让其自动生成的id可以赋值到形参当中
     * @param mechant
     */
    public void insertMechant(Mechant mechant){
        mechantMapper.insertMechant(mechant);
    }

    /**
     * 更新商家的信息
     * @param mechant
     */
    public void updateMechant(Mechant mechant){
        mechantMapper.updateMechant(mechant);
    }

    /**
     * 根据id查找商家的信息
     * @param id
     * @return
     */
    public Mechant findMechantById(int id){
        return mechantMapper.findMechantById(id);
    }

    /**
     * 更新商家的状态，审核通过，提交成功还是审核不通过
     * @param mechant
     */
    public void upateMechantStatus(Mechant mechant){
        mechantMapper.upateMechantStatus(mechant);
    }

    /**
     * 更新商家的经营状态是正常发售还是已经下架
     * @param mechant
     */
    public void upateSoldout(Mechant mechant){
        mechantMapper.upateSoldout(mechant);
    }
}
