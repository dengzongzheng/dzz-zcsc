package com.dzz.zcsc.service.impl;

import com.dzz.zcsc.common.enums.CategoryEnum;
import com.dzz.zcsc.common.page.PageUtil;
import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.bo.HomeGoodsBo;
import com.dzz.zcsc.domain.dto.ListParamDto;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.domain.vo.GoodsDetailVo;
import com.dzz.zcsc.domain.vo.GoodsHomeVo;
import com.dzz.zcsc.domain.vo.GoodsListVo;
import com.dzz.zcsc.service.GoodsService;
import com.google.common.base.Strings;
import com.mongodb.client.result.DeleteResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    public ResponseDzz<Boolean> delete(String productNo) {
        Query query = new Query();
        query.addCriteria(Criteria.where("product_no").is(productNo));
        DeleteResult deleteResult = mongoTemplate.remove(query, "goods");
        return ResponseDzz.ok(deleteResult.getDeletedCount() > 0);
    }

    @Override
    public ResponseDzz<GoodsHomeVo> listHome() {

        Sort sort = new Sort(Direction.ASC, "update_date");
        Criteria porcelain = Criteria.where("category_code").is(CategoryEnum.PORCELAIN.getCode());
        Criteria jade = Criteria.where("category_code").is(CategoryEnum.JADE.getCode());
        Criteria picture = Criteria.where("category_code").is(CategoryEnum.PICTURE.getCode());
        Criteria other = Criteria.where("category_code").is(CategoryEnum.OTHER.getCode());
        List<HomeGoodsBo> porcelains = mongoTemplate
                .find(new Query().addCriteria(porcelain).limit(6).with(sort), HomeGoodsBo.class, "goods");
        List<HomeGoodsBo> jades = mongoTemplate
                .find(new Query().addCriteria(jade).limit(6).with(sort), HomeGoodsBo.class, "goods");
        List<HomeGoodsBo> pictures = mongoTemplate
                .find(new Query().addCriteria(picture).limit(6).with(sort), HomeGoodsBo.class, "goods");
        List<HomeGoodsBo> others = mongoTemplate
                .find(new Query().addCriteria(other).limit(6).with(sort), HomeGoodsBo.class, "goods");

        GoodsHomeVo goodsHomeVo = new GoodsHomeVo();
        goodsHomeVo.setJades(jades);
        goodsHomeVo.setOthers(others);
        goodsHomeVo.setPictures(pictures);
        goodsHomeVo.setPorcelains(porcelains);
        return ResponseDzz.ok(goodsHomeVo);
    }

    @Override
    public ResponseDzz<GoodsDetailVo> findGoodsByProductNo(String productNo) {
        Query query = new Query();
        Criteria criteria = Criteria.where("product_no").is(productNo);
        query.addCriteria(criteria);
        GoodsDetailVo goodsDetailVo = mongoTemplate.findOne(query, GoodsDetailVo.class, "goods");
        return ResponseDzz.ok(goodsDetailVo);
    }

    @Override
    public ResponseDzz<PageUtil> listGoods(ListParamDto param) {

        PageUtil<GoodsListVo> pageUtil = new PageUtil<>();
        pageUtil.setPageSize(param.getPageSize());
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
        List<GoodsListVo> listVoList = mongoTemplate
                .find(query.skip((pageUtil.getPageNo() - 1) * pageUtil.getPageSize()), GoodsListVo.class, "goods");
        pageUtil.setData(listVoList);
        long count = mongoTemplate.count(query, "goods");
        pageUtil.setTotalCount((int) count);
        pageUtil.setTotalPage();

        return ResponseDzz.ok(pageUtil);
    }

    @Override
    public ResponseDzz<PageUtil> findGoodsByCategory(Integer categoryCode, Integer pageNo,
            Integer pageSize) {

        PageUtil<GoodsListVo> pageUtil = new PageUtil<>();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        Sort sort = new Sort(Direction.ASC, "update_date");
        Query query = new Query();
        Criteria porcelain = Criteria.where("category_code").is(categoryCode);
        query.addCriteria(porcelain);
        query.limit(pageUtil.getPageSize());
        List<GoodsListVo> list = mongoTemplate
                .find(query.skip((pageUtil.getPageNo() - 1) * pageUtil.getPageSize()).with(sort), GoodsListVo.class,
                        "goods");
        pageUtil.setData(list);
        long count = mongoTemplate.count(query, "goods");
        pageUtil.setTotalCount((int) count);
        pageUtil.setTotalPage();
        return ResponseDzz.ok(pageUtil);
    }
}
