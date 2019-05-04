package com.dzz.zcsc.domain.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 列表查询条件
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 22:23
 */
@Data
public class ListParamDto implements Serializable {

    private static final long serialVersionUID = -5739897758258968591L;

    /**
     * 名称
     */
    private String productName;

    /**
     * 分类code
     * @see com.dzz.zcsc.common.enums.CategoryEnum code
     */
    private Integer categoryCode;

    /**
     * 页号
     */
    private Integer pageNo;


    /**
     * 每页条数
     */
    private Integer pageSize;
}
