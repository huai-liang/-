package com.example.shop.admin.controller;

import com.example.shop.admin.model.Admin;
import com.example.shop.admin.service.AdminService;
import com.example.shop.base.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ASUS
 * @Date: 2019/11/20 19:22
 * @Description:
 */
@RestController
@RequestMapping("/Admincontroller")
@Api(description = "管理员")
public class Admincontroller {
    @Autowired
    AdminService adminService;

    @PostMapping("/addAdmin")
    @ApiOperation(value = "管理员新增")
    public Response addAdmin(@RequestBody Admin admin) {
        int count = adminService.addAdmin(admin);
        if (count <= 0) {
            return Response.error("管理新增失败");
        }
        return Response.ok("管理员新增成功");
    }

    @PostMapping("/delAdmin")
    @ApiOperation(value = "管理员删除")
    public Response delAdmin(@RequestBody Admin admin) {
        int count = adminService.delAdmin(admin);
        if (count <= 0) {
            return Response.error("删除失败");
        }
        return Response.ok("管理员删除成功");
    }


    @PostMapping("/selectAdmin")
    @ApiOperation(value = "管理员登陆")
    public Response selectAdmin(@RequestBody Admin admin) {
        Admin admin1= adminService.selectAdmin(admin);
        if (admin.getName().equals(admin1.getName())&&
                admin.getPassword().equals(admin1.getPassword())) {
            return Response.ok(admin,"登陆成功");
        }
        return Response.error("账号密码错误");
    }

}
