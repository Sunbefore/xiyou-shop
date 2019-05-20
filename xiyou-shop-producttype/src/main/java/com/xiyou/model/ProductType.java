package com.xiyou.model;

import lombok.Data;

/**
 * 产品名称
 */
@Data
public class ProductType {
    private int id;
    private String producttypename;
    private String producttypedescription;
    private String typegrade;//等级比如1,2,3 1是最大的分类
    private int parentid;//如果是第一类别，父节点就为-1
}
