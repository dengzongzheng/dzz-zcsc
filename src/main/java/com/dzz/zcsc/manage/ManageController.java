package com.dzz.zcsc.manage;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.service.GoodsService;
import com.dzz.zcsc.service.impl.GoodsServiceMongoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 14:41
 */
@RequestMapping("/manage/api")
public class ManageController {

    private GoodsService goodsService;

    public ManageController(GoodsServiceMongoImpl goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 首页数据
     * @return 结果
     */
    @GetMapping("/saveGoods")
    public ResponseDzz saveGoods(Goods goods) {

        return goodsService.saveGoods(goods);
    }

}
