package com.dzz.zcsc.manage;

import com.dzz.zcsc.common.page.PageUtil;
import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.dto.ListParamDto;
import com.dzz.zcsc.domain.model.Goods;
import com.dzz.zcsc.service.GoodsService;
import com.dzz.zcsc.service.IdService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    private IdService idService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Autowired
    public void setIdService(IdService idService) {
        this.idService = idService;
    }

    /**
     * 首页数据
     * @return 结果
     */
    @PostMapping("/saveGoods")
    public ResponseDzz saveGoods(@RequestBody Goods goods) {

        goods.setProductNo(String.valueOf(idService.getId()));
        goods.setUpdateDate(new Date());
        goods.setCreateDate(goods.getUpdateDate());
        goods.setUpdater("admin");
        goods.setCreator("admin");
        return goodsService.saveGoods(goods);
    }


    /**
     * 列表查询
     * @param param 查询条件
     * @return 结果
     */
    @GetMapping("/listGoods")
    public ResponseDzz<PageUtil> listGoods(ListParamDto param){

        return goodsService.listGoods(param);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }
}
