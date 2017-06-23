package com.example.demo;

import java.lang.annotation.*;

/**
 * Created by archerlj on 2017/6/23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

    public String description();
}
