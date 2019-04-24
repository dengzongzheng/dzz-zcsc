package com.dzz.zcsc.website;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.vo.GoodsCategoryListVo;
import com.dzz.zcsc.domain.vo.GoodsDetailVo;
import com.dzz.zcsc.domain.vo.GoodsHomeVo;
import com.dzz.zcsc.service.GoodsService;
import com.dzz.zcsc.service.impl.GoodsServiceMongoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月23 23:40
 */
@RestController
@RequestMapping("/api")
public class GoodsController {

    private GoodsService goodsService;

    public GoodsController(GoodsServiceMongoImpl goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }


    /**
     * 首页数据
     * @return 结果
     */
    @GetMapping("/listHome")
    public ResponseDzz<GoodsHomeVo> listHome() {

        return goodsService.listHome();
    }

    /**
     * 分类列表
     * @param categoryCode 分类编码
     * @param pageNo 页号
     * @param pageSize 每页条数
     * @return 结果
     */
    @GetMapping("/listCategory")
    public ResponseDzz<GoodsCategoryListVo> listCategory(Integer categoryCode,Integer pageNo,Integer pageSize){

        return goodsService.findGoodsByCategory(categoryCode, pageNo, pageSize);
    }

    /**
     * 详情
     * @param productNo 编号
     * @return 结果
     */
    @GetMapping("/detail")
    public ResponseDzz<GoodsDetailVo> detail(String productNo){

        return goodsService.findGoodsByProductNo(productNo);
    }
}
