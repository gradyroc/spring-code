package cn.grady;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.TimeUnit;

/**
 * @author gradyzhou
 * @version 1.0, on 10:50 2019/12/31.
 */
public class guavaCacheTest {

    public static void main(String[] args) {


        //元素移除监听器
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
            }
        };

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .removalListener(listener)
                .recordStats() //开启统计信息开关
                .build();

        //打印cache的状态信息，命中率等
        System.out.println(cache.stats());
    }
}
