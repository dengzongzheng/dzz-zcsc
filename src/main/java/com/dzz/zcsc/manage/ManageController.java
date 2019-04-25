package com.dzz.zcsc.manage;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.service.GoodsService;
import com.dzz.zcsc.service.impl.GoodsServiceMongoImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 14:41
 */
@RestController
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
    @PostMapping("/saveGoods")
    public ResponseDzz saveGoods(@RequestBody Goods goods) {

        return goodsService.saveGoods(goods);
    }

}
