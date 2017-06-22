package com.example.demo;

/**
 * Created by archerlj on 2017/6/22.
 */
public interface UserDao {

    public void saveUser(UserEntity user);
    public UserEntity findUserByUserName(String userName);
    public void updateUser(UserEntity user);
    public void deleteUserById(Long id);
}
