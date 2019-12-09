package com.example.shop.order.model;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: ASUS
 * @Date: 2019/11/8 19:01
 * @Description:
 */
@Data
public class Order {
    private double total;
    private Date createTime;
    private String phone;
    private Integer status;
    private Long goodsId;
    private Integer num;
    private String address;
    private  Integer pageSize;
    private Integer pageNum;
    private  String title;
    private String imageSrc;

}