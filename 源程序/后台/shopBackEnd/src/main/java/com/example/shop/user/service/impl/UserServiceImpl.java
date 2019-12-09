package com.example.shop.user.service.impl;


import com.example.shop.base.Response;
import com.example.shop.user.mapper.UserMapper;
import com.example.shop.user.model.User;
import com.example.shop.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/10/26 19:52
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * description: 登陆用户
     * Param: [user]
     * return: com.example.shop.user.model.User
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 1:30
     */
    @Override
    public User login(User user) {
        User user1 = userMapper.login(user);
        return user1;
    }

    /**
     * description: 添加用户
     * Param: [user]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 1:30
     */
    @Override
    public int addUser(User user) {
        int count = userMapper.addUser(user);
        return count;
    }


    /**
     * description: 更改密码
     * Param: [user]
     * return: com.example.shop.user.model.User
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:02
     */
    @Override
    public int updateUser(User user) {
        int count = userMapper.updateUser(user);
        return count;
    }


    /**
     * description: 判断用户是否存在
     * Param: [user]
     * return: com.example.shop.user.model.User
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 6:30
     */
    @Override
    public User register(User user) {
        User user1 = userMapper.register(user);
        return user1;
    }

    @Override
    public User selectStatus(String user) {
        User user1 = userMapper.selectStatus(user);
        return user1;
    }

    @Override
    public int modifyStatus(User user) {
        int count = userMapper.modifyStatus(user);
        return count;
    }

    @Override
    public Response getUserList(User user) {
        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<User> list=userMapper.getUserList(user);
        if (list.size()<=0){
            return Response.ok("查询失败");
        }
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return Response.ok(pageInfo,"查询成功");
    }

    @Override
    public List<User> getUser(User user) {
        return  userMapper.getUser(user);
    }
}
