package com.douma.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-16 17:27
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String helloWold(String name) {
        return "Hello World, " + name;
    }

}