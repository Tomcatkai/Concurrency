package com.kaizhang.concurrency.example.singleton;

import com.kaizhang.concurrency.annotations.Recommend;
import com.kaizhang.concurrency.annotations.ThreadSafe;

/**
 * 使用枚举 进行单例
 *
 * 相比懒汉模式在安全性上更有保证,其次相比饿汉模式,可以在实际调用时才
 * 做最开始的初始化,而在后续使用的时候也可以直接取到里面的值,不会造成资源
 * 的浪费.
 *
 * @author kaizhang
 * @create 2019-05-02 16:33
 **/

@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
