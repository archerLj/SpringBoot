package com.example.demo;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by archerlj on 2017/6/23.
 */

@RestController
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @LoggerManage(description = "获取用户名")
    public String getUserName(String userID, Integer age) {
        return "ArcherLj";
    }
}
