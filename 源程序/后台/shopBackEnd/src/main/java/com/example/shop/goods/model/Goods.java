package com.example.shop.goods.model;

import lombok.Data;

/**
 * @Auther: ASUS
 * @Date: 2019/11/4 13:53
 * @Description:
 */
@Data
public class Goods {
    private String title;
    private String imageSrc;
    private Double price;
    private Long goodsId;
    private Long reserves;
    private Integer status;

    private Integer pageNo;
    private Integer pageNum;
    private  String keytitle;
}
