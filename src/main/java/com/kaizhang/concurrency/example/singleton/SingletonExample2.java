package com.kaizhang.concurrency.example.singleton;

/**
 * 安全发布对象
 *
 * @author kaizhang
 * @create 2019-05-02 11:19
 **/

import com.kaizhang.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载使用时创建
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
