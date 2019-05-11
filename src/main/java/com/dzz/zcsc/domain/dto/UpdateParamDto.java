package com.dzz.zcsc.domain.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 更新数据DTO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年05月11 10:12
 */
@Data
public class UpdateParamDto implements Serializable {

    private static final long serialVersionUID = 97265307155183516L;

    @Field("product_no")
    private String productNo;

    /**
     * 名称
     */
    @Field("product_name")
    private String productName;

    /**
     * 访问量
     */
    @Field("visit_count")
    private Integer visitCount;


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
}
