package com.dzz.zcsc.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 列表信息Vo
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 22:27
 */
@Data
public class GoodsListVo implements Serializable {

    private static final long serialVersionUID = 2947901142867620676L;

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
     * 更新时间
     */
    @Field("update_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date updateDate;

}
