package com.dzz.zcsc.domain.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 首页商品BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 21:41
 */
@Data
public class HomeGoodsBo implements Serializable {

    private static final long serialVersionUID = -8836473039479422137L;

    /**
     * 编号
     */
    @Field("product_no")
    private String productNo;

    /**
     * 名称
     */
    @Field("product_name")
    private String productName;


    /**
     * 描述
     */
    @Field("direction")
    private String direction;


    /**
     * 分类code
     * @see com.dzz.zcsc.common.enums.CategoryEnum code
     */
    @Field("category_code")
    private Integer categoryCode;


    /**
     * 分类
     * @see com.dzz.zcsc.common.enums.CategoryEnum name
     */
    @Field("category_name")
    private String categoryName;


    /**
     * 图片
     */
    @Field("product_images")
    private List<String> productImages;


    /**
     * 更新时间
     */
    @Field("update_date")
    private Date updateDate;
}
