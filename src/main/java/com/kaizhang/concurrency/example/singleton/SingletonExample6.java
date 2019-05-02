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
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){

    }

    //静态域和静态方法需要注意书写顺序

    //单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
