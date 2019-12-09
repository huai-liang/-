package com.example.shop.admin.mapper;
import com.example.shop.admin.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int addAdmin(Admin admin);

    Admin selectAdmin(Admin admin);

    int delAdmin(Admin admin);
}
