package com.dzz.zcsc.service;

import com.dzz.zcsc.common.page.PageUtil;
import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.dto.ListParamDto;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.domain.vo.GoodsDetailVo;
import com.dzz.zcsc.domain.vo.GoodsHomeVo;

/**
 * 商品接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 09:32
 */
public interface GoodsService {


    /**
     * 保存
     * @param goods goods
     * @return 保存结果
     */
    ResponseDzz saveGoods(Goods goods);


    /**
     * 删除数据
     * @param productNo 编号
     * @return 结果
     */
    ResponseDzz<Boolean> delete(String productNo);

    /**
     * 首页数据查询
     * @return 数据数据
     */
    ResponseDzz<GoodsHomeVo> listHome();


    /**
     * 详情
     * @param productNo 编号
     * @return 查询结果
     */
    ResponseDzz<GoodsDetailVo> findGoodsByProductNo(String productNo);

    /**
     * 列表查询
     * @param param 参数
     * @return 结果
     */
    ResponseDzz<PageUtil> listGoods(ListParamDto param);


    /**
     * 按分类查
     * @param categoryCode 分类code
     * @param pageNo 页号
     * @param pageSize 每页条数
     * @return 查询结果
     */
    ResponseDzz<PageUtil> findGoodsByCategory(Integer categoryCode,Integer pageNo,Integer pageSize);

}