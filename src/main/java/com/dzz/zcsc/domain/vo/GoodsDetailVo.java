package com.dzz.zcsc.domain.vo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品详情
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 09:28
 */
@Data
public class GoodsDetailVo implements Serializable {

    private static final long serialVersionUID = -8941044096660529825L;

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
     * 分类
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
}
