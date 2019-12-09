package com.example.shop.shopcar.service.impl;

import com.example.shop.shopcar.mapper.CarMapper;
import com.example.shop.shopcar.model.Car;
import com.example.shop.shopcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Auther: ASUS
 * @Date: 2019/11/1 19:19
 * @Description:
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;

    /**
     * description: 添加购物车
     * Param: [car]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:39
     */
    @Override
    public int addCar(Car car) {
        return carMapper.addCar(car);
    }

    /**
     * description: 删除购物车
     * Param: [car]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:39
     */
    @Override
    public int delCar(List<String> list,List<String> phone) {
        return carMapper.delCar(list,phone);
    }

/**
  *
  * description: 更新购物车
  * Param: [car]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/1 下午 8:58
  */
    @Override
    public int updataCar(Car car) {
        return carMapper.updataCar(car);
    }


/**
  *
  * description: 查询购物车
  * Param: [car]
  * return: com.example.shop.shopcar.model.Car
  * Author: zouhuailiang
  * Date: 2019/11/4 下午 1:37
  */
    @Override
    public List<Car> selectCar(Car car) {
        return carMapper.selectCar(car);
    }

    /**
      *
      * description: 判断购物车里是否有相同商品
      * Param: [goodsId]
      * return: int
      * Author: zouhuailiang
      * Date: 2019/11/8 下午 7:24
      */
    @Override
    public int selectcarById(Car car) {
       return carMapper.selectcarById(car);
    }
}
