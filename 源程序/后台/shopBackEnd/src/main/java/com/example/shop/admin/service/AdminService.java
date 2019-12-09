package com.example.shop.admin.service;

import com.example.shop.admin.model.Admin;

public interface AdminService {
    int addAdmin(Admin admin);

    Admin selectAdmin(Admin admin);

    int delAdmin(Admin admin);
}
