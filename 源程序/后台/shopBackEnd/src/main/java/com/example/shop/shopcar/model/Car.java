package com.example.shop.shopcar.model;

import lombok.Data;


/**
 * @Auther: ASUS
 * @Date: 2019/11/1 19:13
 * @Description:
 */
@Data
public class Car {
    private String phone;
    private String title;
    private String imageSrc;
    private Double price;
    private Integer num;
    private  Long goodsId;

}
