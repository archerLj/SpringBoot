package com.example.demo.service;

import com.example.demo.entity.UserInfo;

/**
 * Created by archerlj on 2017/6/30.
 */
public interface UserInfoService {

    public UserInfo findByUsername(String username);
}
