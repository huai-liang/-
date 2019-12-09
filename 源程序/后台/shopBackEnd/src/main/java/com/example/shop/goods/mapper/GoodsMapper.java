package com.example.shop.goods.mapper;

import com.example.shop.goods.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {


    /**
     * description: 搜索商品
     * Param: [goods]
     * return: java.util.List<com.example.shop.goods.model.Goods>
     * Author: zouhuailiang
     * Date: 2019/11/4 下午 2:40
     */
    List<Goods> selectGoods(Goods goods);

    /**
     * description: 选择商品
     * Param: [goods]
     * return: java.util.List<com.example.shop.goods.model.Goods>
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     */
    List<Goods> Goods(Goods goods);

/**
  *
  * description: 更新商品
  * Param: [goods]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/18 下午 7:32
  */

    int updataGoods(Goods goods);

    List<Goods> select(Goods goods);

    int del(Goods goods);
}
