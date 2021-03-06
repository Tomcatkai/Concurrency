package com.kaizhang.concurrency.example.singleton;
import com.kaizhang.concurrency.annotations.ThreadSafe;

/**
 * 安全发布对象
 *
 * @author kaizhang
 * @create 2019-05-02 11:19
 **/

/**
 * 懒汉模式 -->> 双重同步锁单例模式
 * 单例实例在第一次使用时创建
 */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }

    //1. memory = allocate() 分配对象的内存空间
    //2. ctorInstance 初始化对象
    //3. Instance = memory 设置instance指向刚分配的内存

    // JVM 和 cpu优化  发生了指令重排

    //1. memory = allocate() 分配对象的内存空间
    //3. Instance = memory 设置instance指向刚分配的内存
    //2. ctorInstance 初始化对象


    //由于cup指令重排的存在,双重检测机制并不是线程安全的

    //单例对象  volatile + 双重检测机制  ---> 禁止指令重排
    private static volatile SingletonExample5 instance = null; // 使用volatile 限制指令重排

    //静态工厂方法
    public static SingletonExample5 getInstance(){
        if(instance == null){//双重检测机制                 // B
            synchronized (SingletonExample5.class){//同步锁
                if(instance == null){
                    instance = new SingletonExample5();   // A -3
                }
            }
        }
        return instance;
    }
}
