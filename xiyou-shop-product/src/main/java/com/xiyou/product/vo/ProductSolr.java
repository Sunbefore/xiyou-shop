package com.xiyou.product.vo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by Administrator on 2018/8/5 0005.
 * solr的索引类
 * 表示下面的三个字段会加上索引（solr中）
 */

@Data
public class ProductSolr {
    @Field
    private String id;

    @Field
    private String producttitle;

    @Field
    private String productdescription;
}
