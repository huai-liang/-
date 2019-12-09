package com.example.shop.order.serive;

import com.example.shop.base.Response;
import com.example.shop.order.model.Order;

import java.util.List;

public interface OrderService{

/**
  *
  * description: 添加订单
  * Param: [order]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/11 上午 9:39
  */
    int addOrder(List<Order> list);

/**
  *
  * description: 删除d订单
 * Param: [order]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/11 上午 9:38
  */
int delOrder(List<String> list,List<String> phone);



    Response selectOrder(Order order);


}
