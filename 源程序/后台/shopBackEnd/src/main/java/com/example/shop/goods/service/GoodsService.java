package com.example.shop.goods.service;


import com.example.shop.base.Response;
import com.example.shop.goods.model.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * description: 搜索商品
     * Param: [goods]
     * return: java.util.List<com.example.shop.goods.model.Goods>
     * Author: zouhuailiang
     * Date: 2019/11/4 下午 2:41
     */
    List<Goods> selectGoods(Goods goods);


/**
  *
  * description: 选择商品
  * Param: [goods]
  * return: java.util.List<com.example.shop.goods.model.Goods>
  * Author: zouhuailiang
  * Date: 2019/11/13 下午 1:24
 * @return
 */

    List<Goods> Goods(Goods goods);



    int updataGoods(Goods goods);

    Response select(Goods goods);

    int del(Goods goods);
}
