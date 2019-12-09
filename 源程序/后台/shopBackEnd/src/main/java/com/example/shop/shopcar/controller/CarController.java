package com.example.shop.shopcar.controller;


import com.example.shop.base.Response;
import com.example.shop.shopcar.model.Car;
import com.example.shop.shopcar.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ASUS
 * @Date: 2019/11/1 19:18
 * @Description:
 */
@Api(description = "购物车")
@RestController
@RequestMapping("/ShopCarController")
public class CarController {

    @Autowired
    CarService carService;

    /**
     * description: 添加购物车
     * Param: [car]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:37
     */
    @ApiOperation(value = "添加购物车")
    @PostMapping("/addCar")
    public Response addCar(@RequestBody Car car) {
        int count1=carService.selectcarById(car);
        if (count1>0){
            return Response.error("商品已在购物车等您");
        }
        int count = carService.addCar(car);
        if (count <= 0) {
            return Response.error("购物车添加失败");
        }
        return Response.ok("购物车添加成功");
    }

    /**
     * description: 删除购物车
     * Param: [car]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 8:38
     */
    @ApiOperation(value = "删除购物车")
    @PostMapping("/delCar")
    public Response delCar(@RequestBody Map<String,List<String>> parMap) {
        int count = carService.delCar(parMap.get("list"),parMap.get("phone"));
        if (count <= 0) {
            return Response.error("购物车删除失败");
        }
        return Response.ok("购物车删除成功");
    }


    /**
      *
      * description: 更新购物车
      * Param: [car]
      * return: com.example.shop.base.Response
      * Author: zouhuailiang
      * Date: 2019/11/1 下午 8:58
      */
    @ApiOperation(value = "更新购物车")
    @PostMapping("/updataCar")
    public Response updataCar(@RequestBody Car car) {
        int count = carService.updataCar(car);
        if (count <= 0) {
            return Response.error("更新购物车失败");
        }
        return Response.ok("更新购物车成功");
    }
    /**
      *
      * description: 查询购物车
      * Param: [car]
      * return: com.example.shop.base.Response
      * Author: zouhuailiang
      * Date: 2019/11/4 下午 1:36
      */
    @ApiOperation(value = "查询购物车")
    @PostMapping("/selectCar")
    public Response selectCar(@RequestBody Car car) {
       List<Car> count=carService.selectCar(car);
        if (count.size() <0){
            return Response.error("查询购物车失败");
        }
        return Response.ok(count,"查询购物车成功");

    }

}
