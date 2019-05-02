package com.kaizhang.concurrency.example.publish;

import com.kaizhang.concurrency.annotations.NotRecommend;
import com.kaizhang.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象溢出
 *
 * @author kaizhang
 * @create 2019-05-02 11:00
 **/

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public  Escape(){
        new InnerClass();
    }

    private class InnerClass{

        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
