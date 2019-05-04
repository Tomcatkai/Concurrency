package com.kaizhang.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.kaizhang.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 不可变对象测试类  final
 *
 * @author kaizhang
 * @create 2019-05-03 15:57
 **/

@Slf4j
@NotThreadSafe
public class ImmutableExample2 {
    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
        log.info("{}",map.get(1));

    }



}
