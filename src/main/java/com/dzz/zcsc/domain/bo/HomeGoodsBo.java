package com.dzz.zcsc.domain.bo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
     * 更新时间
     */
    private Date updateDate;
}
