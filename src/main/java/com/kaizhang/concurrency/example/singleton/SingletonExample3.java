package com.kaizhang.concurrency.example.singleton;

/**
 * 安全发布对象
 *
 * @author kaizhang
 * @create 2019-05-02 11:19
 **/

import com.kaizhang.concurrency.annotations.NotRecommend;
import com.kaizhang.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
