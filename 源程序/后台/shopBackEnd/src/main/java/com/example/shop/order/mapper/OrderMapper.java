package com.example.shop.order.mapper;

import com.example.shop.order.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    int addOrder(List<Order> list);

    List<Order> selectOrder(Order order);

    int delOrder(List<String> list,List<String> phone);
}
