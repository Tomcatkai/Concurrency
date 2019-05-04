package com.kaizhang.concurrency.example.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * threadlocal controller
 *
 * @author kaizhang
 * @create 2019-05-04 9:54
 **/

@RestController
@RequestMapping("/threadlocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    public Long test(){
        return RequestHolder.getId();
    }
}
