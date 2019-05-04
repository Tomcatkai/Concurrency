package com.kaizhang.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.kaizhang.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 不可变对象测试类  final
 *
 * @author kaizhang
 * @create 2019-05-03 15:57
 **/

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//       基本数据类型被final修饰编译阶段就无法修改
//        a = 2;
//        b = 3;

        //引用数据类型: 一旦赋值了之后就不能再指向另外一个对象.
//        map = Maps.newHashMap();

        map.put(1,3);
        log.info("{}",map.get(1));

    }

    private void test(final int a){
        //传入参数,基本类型也不可以修改
//        a = 1;
    }



}
