package com.example.shop.goods.service.impl;

import com.example.shop.base.Response;
import com.example.shop.goods.mapper.GoodsMapper;
import com.example.shop.goods.model.Goods;
import com.example.shop.goods.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/11/4 13:58
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    /**
     * description: 搜索商品
     * Param: [goods]
     * return: java.util.List<com.example.shop.goods.model.Goods>
     * Author: zouhuailiang
     * Date: 2019/11/4 下午 2:41
     */
    @Override
    public List<Goods> selectGoods(Goods goods) {
        return goodsMapper.selectGoods(goods);
    }




    /**
     * description: 选择商品
     * Param: [goods]
     * return:
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     * @return
     */
    @Override
    public List<Goods> Goods(Goods goods) {

        return goodsMapper.Goods(goods);
    }


    @Override
    public int updataGoods(Goods goods) {
        return goodsMapper.updataGoods(goods);
    }

    @Override
    public Response select(Goods goods) {
        PageHelper.startPage(goods.getPageNum(), goods.getPageNo());
        List<Goods> list=goodsMapper.select(goods);
        if (list.size()<=0){
            return Response.error("查询失败");
        }
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        return Response.ok(pageInfo,"查询成功");
    }

    @Override
    public int del(Goods goods) {
        return goodsMapper.del(goods);
    }
}
