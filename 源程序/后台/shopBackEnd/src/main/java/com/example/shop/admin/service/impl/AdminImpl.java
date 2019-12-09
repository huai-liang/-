package com.example.shop.admin.service.impl;

import com.example.shop.admin.mapper.AdminMapper;
import com.example.shop.admin.model.Admin;
import com.example.shop.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: ASUS
 * @Date: 2019/11/20 19:59
 * @Description:
 */
@Service
public class AdminImpl  implements AdminService {
  @Autowired
  AdminMapper adminMapper;

  @Override
  public int addAdmin(Admin admin) {
    int count =adminMapper.addAdmin(admin);
    return count;
  }

  @Override
  public Admin selectAdmin(Admin admin) {
    Admin admin1= adminMapper.selectAdmin(admin);
    return admin1;
  }

  @Override
  public int delAdmin(Admin admin) {
    return adminMapper.delAdmin(admin);
  }
}
