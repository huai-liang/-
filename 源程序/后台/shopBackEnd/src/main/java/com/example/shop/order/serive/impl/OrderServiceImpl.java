package com.example.shop.order.serive.impl;

import com.example.shop.base.Response;
import com.example.shop.order.mapper.OrderMapper;
import com.example.shop.order.model.Order;
import com.example.shop.order.serive.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/11/8 19:07
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;


    /**
     * description: 添加订单
     * Param: [order]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/11 上午 9:44
     */
    @Override
    public int addOrder(List<Order> list) {

        return orderMapper.addOrder(list);
    }


    /**
     * description: 删除订单
     * Param: [order]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/11 上午 9:44
     */
    @Override
    public int delOrder(List<String> list,List<String> phone) {
        return orderMapper.delOrder(list,phone);
    }


    /**
      *
      * description: 查询订单
      * Param: [order]
      * return: com.example.shop.base.Response
      * Author: zouhuailiang
      * Date: 2019/12/2 下午 2:41
      */
    @Override
    public Response selectOrder(Order order) {
        PageHelper.startPage(order.getPageNum(), order.getPageSize());
        List<Order> list = orderMapper.selectOrder(order);
        if (list.size()<=0){
            return Response.error("没有订单");
        }
        PageInfo<Order> pageInfo= new PageInfo<> (list);
        return  Response.ok(pageInfo,"订单查询成功");

    }
}
