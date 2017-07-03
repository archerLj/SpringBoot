package com.example.demo.web;

import com.example.demo.repository.UserInfoRepository;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by archerlj on 2017/6/30.
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    @ExceptionHandler(UnauthorizedException.class)
    public String userInfoDel() {
        return "userInfoDel";
    }
}
