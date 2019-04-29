package com.dzz.zcsc.service;

import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.domain.model.User;

/**
 * 用户服务接口
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 15:07
 */
public interface UserService {

    /**
     * 根据用户名取用户信息
     * @param userName 用户名称
     * @return 用户信息
     */
    ResponseDzz<User> getUserByName(String userName);


    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 结果
     */
    ResponseDzz saveUser(User user);
}
