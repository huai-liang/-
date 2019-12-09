package com.example.shop.user.service;


import com.example.shop.base.Response;
import com.example.shop.user.model.User;

import java.util.List;

public interface UserService {
    /**
     * description: 注册用户
     * Param: [user]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:40
     */
    int addUser(User user);

    /**
     * description: 登陆用户
     * Param: [user]
     * return: com.example.shop.user.model.User
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:40
     */
    User login(User user);

    /**
     * description: 更新用户
     * Param: [user]
     * return: int
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:40
     */
    int updateUser(User user);

    /**
     * description: 判断用户是否注册
     * Param: [user]
     * return: com.example.shop.user.model.User
     * Author: zouhuailiang
     * Date: 2019/11/1 下午 2:41
     */
    User register(User user);


/**
  *
  * description: 账号的状态
  * Param: [user]
  * return: com.example.shop.user.model.User
  * Author: zouhuailiang
  * Date: 2019/11/8 下午 5:31
  */
 User selectStatus(String phone);


 /**
   *
   * description: 修改用户状态
   * Param: [user]
   * return: int
   * Author: zouhuailiang
   * Date: 2019/11/21 上午 7:54
   */

    int modifyStatus(User user);

    Response getUserList(User user);

    List<User> getUser(User user);
}
