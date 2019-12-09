package com.example.shop.shopcar.service;


import com.example.shop.shopcar.model.Car;

import java.util.List;


public interface CarService {
    /**
     * description: 添加购物车
     * Param: [car]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:47
     */
    int addCar(Car car);

    /**
     * description: 删除购物车
     * Param: [car]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:48
     */
    int delCar(List<String> list,List<String> phone);

/**
  *
  * description: 更新购物车
  * Param: [car]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/1 下午 8:56
  */
    int updataCar(Car car);
    /**
      *
      * description: 查询购物车
      * Param: [car]
      * return: com.example.shop.shopcar.model.Car
      * Author: zouhuailiang
      * Date: 2019/11/4 下午 1:36
      */

    List<Car> selectCar(Car car);
/**
  *
  * description: 判断购物车里是否有相同商品
  * Param: [goodsId]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 7:22
  */
    int selectcarById(Car car);
}
