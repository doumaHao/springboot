package com.douma.springboot.web.controller;

import com.douma.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-16 18:42
 */
@RestController
public class EnvController {

    @Autowired
    private HelloService helloService;

    @GetMapping("env")
    public String getConfig() {
        return helloService.getNowConfig();
    }

    @GetMapping("get")
    public String get() {
        return helloService.get();
    }
}