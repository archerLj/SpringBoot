package com.example.demo.service.impl;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by archerlj on 2017/6/30.
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {

        System.out.println("UserInfoServiceImpl.findByUsername");
        return userInfoRepository.findByUsername(username);
    }
}
