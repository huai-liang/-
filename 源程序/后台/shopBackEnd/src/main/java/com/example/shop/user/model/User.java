package com.example.shop.user.model;

import lombok.Data;

/**
 * @Auther: ASUS
 * @Date: 2019/10/26 19:16
 * @Description:
 */
@Data
public class User {
    private String phone;
    private String userName;
    private String userPwd;
    private String address;
    private  String status;



    private Integer pageNum;
    private Integer pageSize;

}
