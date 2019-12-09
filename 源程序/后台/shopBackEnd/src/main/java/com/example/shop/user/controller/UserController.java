package com.example.shop.user.controller;

import com.example.shop.base.Response;
import com.example.shop.user.model.User;
import com.example.shop.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/10/26 19:09
 * @Description:用户相关
 */
@Api(description = "用户相关")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * description: 添加用户
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 1:29
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "注册用户")
    public Response addUser(@RequestBody User user) {
        try {
            User user1 = userService.register(user);
            if (user1 == null) {
                int count = userService.addUser(user);
                if (count <= 0) {
                    return Response.error("注册失败");
                }
                return Response.ok(user, "注册成功");
            } else {
                return Response.error("手机号码已经注册");
            }
        } catch (Exception e) {
            return Response.error("数据库内部错误");
        }

    }

    /**
     * description: 登录用户
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 1:30
     */

    @ApiOperation(value = "登陆用户")
    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        try {
            User user1 = userService.register(user);
            if (user1 == null) {
                return Response.error("该用户没有注册");
            }
            User status = userService.selectStatus(user.getPhone());
            if (status.getStatus().equals("2")) {
                return Response.error("该用户因违反协议,已冻结");
            }
            User login = userService.login(user);
            if (login.getPhone().equals(user.getPhone()) &&
                    login.getUserPwd().equals(user.getUserPwd())) {

                return Response.ok(login, "登陆成功");
            }
            return Response.error("密码或者账号错误");
        } catch (Exception e) {
            return Response.error("数据库内部错误");
        }
    }

    /***
     *
     * description: 更改密码
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:01
     */
    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser")
    public Response updateUser(@RequestBody User user) {
        try {
            User user1 = userService.register(user);
            if (user1 == null) {
                return Response.error("该用户没有注册");
            }
            User status = userService.selectStatus(user.getPhone());

            if (status.getStatus().equals("2")) {
                return Response.error("该用户因违反协议,已冻结");
            }
            int count = userService.updateUser(user);
            if (count >= 1) {
                return Response.ok(user, "修改成功");
            }
            return null;
        } catch (Exception e) {
            return Response.error("数据库内部错误");
        }
    }

    /**
     * description: 修改用户状态
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/21 下午 9:06
     */
    @PostMapping("/modifyStatus")
    @ApiOperation(value = "修改用户状态")
    public Response modifyStatus(@RequestBody User user) {
        int count = userService.modifyStatus(user);
        if (count <= 0) {
            return Response.error("修改状态失败");
        }
        return Response.ok("修改用户状态成功");
    }
    /**
     * description: 获取所有用户
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/21 下午 9:06
     */
    @PostMapping("/getUserList")
    @ApiOperation(value = "获取所有用户")
    public Response getUserList(@RequestBody User user) {
       Response response = userService.getUserList(user);
        System.out.println(response);
       return response;

    }

    /**
     * description: 修改用户状态
     * Param: [user]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/21 下午 9:06
     */
    @PostMapping("/getUser")
    @ApiOperation(value = "获取用户")
    public Response getUser(@RequestBody User user) {
        List<User> list = userService.getUser(user);
        if (list.size()<=0){
            return Response.error("没有该用户");
        }
        return Response.ok("查询成功");
    }
}
