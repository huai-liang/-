package com.example.shop.base;

import lombok.Data;

@Data
public class LoginResult {
    private Long userId;
    private String userName;
    private String token;
}