package com.kaizhang.concurrency.example.threadlocal;

/**
 * 存储希望绑定到线程上面的信息
 *
 * @author kaizhang
 * @create 2019-05-04 8:28
 **/

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static  void  add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
