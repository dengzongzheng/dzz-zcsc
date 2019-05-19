package com.dzz.zcsc.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 商品实体
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 09:26
 */
@Data
@Document(collection = "goods")
@CompoundIndexes({
    @CompoundIndex(name = "category_code",def ="{'update_date':-1,'category_code':-1}")
})
public class Goods implements Serializable {

    private static final long serialVersionUID = -2738017337100446962L;


    /**
     * 编号
     */
    @Indexed(unique = true)
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
     * 价格
     */
    @Field("price")
    private String price;

    /**
     * 图片
     */
    @Field("product_images")
    private List<String> productImages;


    /**
     * 创建者
     */
    @Field("creator")
    private String creator;

    /**
     * 更新者
     */
    @Field("updater")
    private String updater;

    /**
     * 创建时间
     */
    @Field("create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Field("update_date")
    private Date updateDate;

}
