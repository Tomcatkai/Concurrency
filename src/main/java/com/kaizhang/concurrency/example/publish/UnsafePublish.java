package com.kaizhang.concurrency.example.publish;

import com.kaizhang.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 线程不安全的发布对象
 *
 * @author kaizhang
 * @create 2019-05-02 10:50
 **/

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a" , "b", "c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}",Arrays.toString(unsafePublish.getStates()));

    }
}
