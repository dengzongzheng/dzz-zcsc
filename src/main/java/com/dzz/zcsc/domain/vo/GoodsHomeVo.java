package com.dzz.zcsc.domain.vo;

import com.dzz.zcsc.domain.bo.HomeGoodsBo;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 首页数据Vo
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 13:55
 */
@Data
public class GoodsHomeVo implements Serializable {

    private static final long serialVersionUID = -2333707236249291881L;

    /**
     * 玉器
     */
    private List<HomeGoodsBo> jades;


    /**
     * 磁器
     */
    private List<HomeGoodsBo> porcelains;


    /**
     * 书画
     */
    private List<HomeGoodsBo> pictures;


    /**
     * 其他
     */
    private List<HomeGoodsBo> others;
}
