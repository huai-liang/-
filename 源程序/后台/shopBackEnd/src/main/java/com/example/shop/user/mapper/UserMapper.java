package com.example.shop.user.mapper;

import com.example.shop.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
/**
  *
  * description: 添加用户
  * Param: [user]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:31
  */
    int addUser(User user);
/**
  *
  * description: 登陆用户
  * Param: [user]
  * return: com.example.shop.user.model.User
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:32
  */
    User login(@Param("user") User user);
/**
  *
  * description: 修改账号
  * Param: [user]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:32
  */
    int updateUser(User user);
/**
  *
  * description: 判断账号是否注册
  * Param: [user]
  * return: com.example.shop.user.model.User
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:32
  */
    User register(@Param("user") User user);
/**
  *
  * description: 判断账号状态
  * Param: [user]
  * return: com.example.shop.user.model.User
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:33
  */
    User selectStatus(String user);
/**
  *
  * description: 修改用户状态
  * Param: [user]
  * return: int
  * Author: zouhuailiang
  * Date: 2019/11/21 上午 7:54
  */
    int modifyStatus(User user);

    List<User> getUserList(User user);

    List<User> getUser(User user);
}
