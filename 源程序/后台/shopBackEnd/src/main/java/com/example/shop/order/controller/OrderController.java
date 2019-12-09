package com.example.shop.order.controller;

import com.example.shop.base.Response;
import com.example.shop.order.model.Order;
import com.example.shop.order.serive.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ASUS
 * @Date: 2019/11/8 19:07
 * @Description:
 */
@RestController
@RequestMapping("/OrderController")
@Api(description = "订单管理")
public class OrderController {
    @Autowired
    OrderService orderService;


    /**
     * description: 添加订单
     * Param: [order]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/11 上午 9:37
     */
    @ApiOperation(value = "下订单")
    @PostMapping("/addOrder")
    public Response addOrder(@RequestBody List<Order> list) {
        if (list.size()<=0){
            return Response.error("请选择您要结算的商品");
        }
        int count = orderService.addOrder(list);
        if (count <= 0) {
            return Response.error("下单失败,小的正在排查错误");
        }
        return Response.ok("恭喜下单成功,商品正在火速派送");
    }
    /**
     * description: 删除订单
     * Param: [order]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/11 上午 9:38
     */
    @PostMapping("/delOrder")
    @ApiOperation("取消订单")
    public Response delOrder(@RequestBody Map<String,List<String>> parMap) {
            int list1= orderService.delOrder(parMap.get("list"),parMap.get("phone"));
            if (list1 <= 0) {
                return Response.error("取消失败,小的正在排查错误");
            }
            return Response.ok("取消订单成功,商品永远在这里等你");

    }


    /**
     * description: 查询订单
     * Param: [order]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/11 上午 9:38
     */
    @PostMapping("/selectOrder")
    @ApiOperation("查询订单")
    public Response selectOrder(@RequestBody Order order){
            Response response = orderService.selectOrder(order);
            return response;
    }
}
