package com.dzz.zcsc.service.impl;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.domain.vo.GoodsCategoryListVo;
import com.dzz.zcsc.domain.vo.GoodsDetailVo;
import com.dzz.zcsc.domain.vo.GoodsHomeVo;
import com.dzz.zcsc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * mongo下接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 13:50
 */
@Service
public class GoodsServiceMongoImpl implements GoodsService {

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ResponseDzz saveGoods(Goods goods) {
        mongoTemplate.save(goods);
        return ResponseDzz.ok(true);
    }

    @Override
    public ResponseDzz<GoodsHomeVo> listHome() {
        return null;
    }

    @Override
    public ResponseDzz<GoodsDetailVo> findGoodsByProductNo(String productNo) {
        return null;
    }

    @Override
    public ResponseDzz<GoodsCategoryListVo> findGoodsByCategory(Integer categoryCode, Integer pageNo,
            Integer pageSize) {
        return null;
    }
}
