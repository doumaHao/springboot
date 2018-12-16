package com.douma.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-16 17:38
 */
@Service
public class HelloService {

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${profile}")
    private String profile;

    @Autowired
    private Environment environment;

    /**
     * 获取当前运行环境
     *
     * @return
     */
    public String getNowConfig() {
        return active;
    }

    public String get() {
//        return environment.getProperty("profile");
        return profile;
    }


}