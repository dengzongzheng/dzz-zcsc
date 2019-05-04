package com.dzz.zcsc.service.impl;

import com.dzz.zcsc.common.page.PageUtil;
import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.dto.ListParamDto;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.domain.vo.GoodsCategoryListVo;
import com.dzz.zcsc.domain.vo.GoodsDetailVo;
import com.dzz.zcsc.domain.vo.GoodsHomeVo;
import com.dzz.zcsc.domain.vo.GoodsListVo;
import com.dzz.zcsc.service.GoodsService;
import com.google.common.base.Strings;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public ResponseDzz<PageUtil> listGoods(ListParamDto param) {

        PageUtil<GoodsListVo> pageUtil = new PageUtil<>();
        pageUtil.setPageSize(10);
        pageUtil.setPageNo(param.getPageNo());
        Query query = new Query();
        Criteria criteria = new Criteria();
        if(!Strings.isNullOrEmpty(param.getProductName())) {
            criteria.and("product_name").is(param.getProductName());
        }
        if(0 != param.getCategoryCode()) {
            criteria.and("category_code").is(param.getCategoryCode());
        }
        query.addCriteria(criteria);
        query.limit(pageUtil.getPageSize());
        List<GoodsListVo> listVoList = mongoTemplate.find(query, GoodsListVo.class,"goods");
        pageUtil.setData(listVoList);
        long count = mongoTemplate.count(query, "goods");
        pageUtil.setTotalCount((int) count);
        pageUtil.setTotalPage();

        return ResponseDzz.ok(pageUtil);
    }

    @Override
    public ResponseDzz<GoodsCategoryListVo> findGoodsByCategory(Integer categoryCode, Integer pageNo,
            Integer pageSize) {
        return null;
    }
}
