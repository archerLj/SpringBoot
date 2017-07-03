package com.example.demo.repository;

import com.example.demo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by archerlj on 2017/6/30.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    public UserInfo findByUsername(String username);
}
