package com.xiyou.mechant.model;

import lombok.Data;

/**
 * 商家的信息
 */
@Data
public class Mechant {
    private int id;
    private String merchantname;
    private String merchantshopname;
    private String merchantaccount;
    private String mechantpassword;
    // 商家的经营范围
    private String mechantscope;
    private int auditstatus;//1提交成功，2审核通过，3审核不通过
    private int soldout;//1,正常，2,下架
}
