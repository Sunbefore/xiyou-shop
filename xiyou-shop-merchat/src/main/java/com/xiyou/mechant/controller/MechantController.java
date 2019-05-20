package com.xiyou.mechant.controller;


import com.xiyou.mechant.model.Mechant;
import com.xiyou.mechant.service.MechantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MechantController {

    @Autowired
    private MechantService mechantService;

    @GetMapping("/toInsertMechant")
    public String toInsertMechant(){
        return "mechantregister";
    }

    /**
     * 插入商家信息
     * 其中因为<selectKey/>的原因，让其自动生成的id可以赋值到形参当中
     * @param mechant
     */
    @PostMapping("/insertMechant")
    public void insertMechant(Mechant mechant){
        mechantService.insertMechant(mechant);
    }

    /**
     * 跳转到更新商家的页面
     * @param
     */
    @GetMapping("/toUpdateMechant/{id}")
    public String toUpdateMechant(@PathVariable Integer id, Model model){
        Mechant mechant = mechantService.findMechantById(id);
        model.addAttribute("mechant", mechant);
        return "mechantupdate";
    }

    /**
     * 更新商家的信息
     * @param mechant
     */
    @PostMapping("/updateMechant")
    public void updateMechant(Mechant mechant){
        mechantService.updateMechant(mechant);
    }

    /**
     * 根据id查找商家的信息
     * @param id
     * @return
     */
    @GetMapping("/findMechantById/{id}")
    public String findMechantById(@PathVariable Integer id, Model model){
        Mechant mechant = mechantService.findMechantById(id);
        model.addAttribute("mechant", mechant);
        return "mechantview";
    }

    /**
     * 跳转到更新商家的页面
     * @param
     */
    @GetMapping("/toUpateMechantStatus/{id}")
    public String toUpateMechantStatus(@PathVariable Integer id, Model model){
        Mechant mechant = mechantService.findMechantById(id);
        model.addAttribute("mechant", mechant);
        return "mechantaudit";
    }

    /**
     * 更新商家的状态，审核通过，提交成功还是审核不通过
     * @param
     */
    @PostMapping("/upateMechantStatus")
    public void upateMechantStatus(Integer status, Integer id){
        mechantService.upateMechantStatus(status, id);
    }


    /**
     * 根据id查询商家信息，跳转到商家经营状态更新界面
     * @param id
     * @return
     */
    @GetMapping("/toUpateSoldout/{id}")
    public String toUpateSoldout(@PathVariable Integer id, Model model){
        Mechant mechant = mechantService.findMechantById(id);
        model.addAttribute("mechant", mechant);
        return "mechantsoldout";
    }

    /**
     * 更新商家的经营状态是正常发售还是已经下架
     * @param
     */
    @PostMapping("/upateSoldout")
    public void upateSoldout(Integer status, Integer id){
        mechantService.upateSoldout(status, id);
    }
}
