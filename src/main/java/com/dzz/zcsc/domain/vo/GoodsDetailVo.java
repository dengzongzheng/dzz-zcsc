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
    private String productNo;

    /**
     * 名称
     */
    private String productName;


    /**
     * 描述
     */
    private String direction;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 图片
     */
    private List<String> productImages;
}
