package com.kaizhang.concurrency.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 *
 * @author kaizhang
 * @create 2019-04-28 18:23
 **/

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
