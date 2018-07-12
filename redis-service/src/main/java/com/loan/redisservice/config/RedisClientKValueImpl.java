/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisClientKValueImpl
 * Author:   user
 * Date:     2018/7/4 17:44
 * Description: 调用公共方法类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice.config;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈调用公共方法类〉
 *
 * @author user
 * @create 2018/7/4
 * @since 1.0.0
 */
@Component
public class RedisClientKValueImpl<V> implements IRedisClientKValue<V> {

    @Autowired
    private StringRedisTemplate redisTemplate;

    protected Class<V> vClass;

    public RedisClientKValueImpl() {

    }

    /**
     * 为指定的key设定指定的value
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param key    对象key(必要)
     * @param value  对象值(必要)
     */
    @Override
    public void set(String appkey, String key, V value) {
        redisTemplate.opsForValue().set(combineKey(appkey, key), this.serialize(value));
    }

    /**
     * 为指定的key设定指定的value和超时时间
     *
     * @param appkey  应用模块的固定key部分(必要)
     * @param key     对象key(必要)
     * @param value   对象值(必要)
     * @param timeout 超时时间(单位毫秒)
     */
    @Override
    public void set(String appkey, String key, V value, long timeout) {

        redisTemplate.opsForValue().set(combineKey(appkey, key), this.serialize(value), timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * 删除指定的key/value
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param key    对象key(必要)
     */
    @Override
    public void delete(String appkey, String key) {

        redisTemplate.delete(combineKey(appkey, key));
    }

    /**
     * 批量为指定的key设定指定的value
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param map    需要设定的值(必要)
     */
    @Override
    public void multiSet(String appkey, Map<String, ? extends V> map) {

        Map<String, String> newMap = new HashMap<String, String>();
        for (String key : map.keySet()) {
            newMap.put(combineKey(appkey, key), this.serialize(map.get(key)));
        }

        redisTemplate.opsForValue().multiSet(newMap);
    }

    /**
     * 获取指定的key的value
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param key    对象key(必要)
     */
    @Override
    public V get(String appkey, String key, Class<? extends V> requireClass) {

        return this.deserialize(redisTemplate.opsForValue().get(combineKey(appkey, key)), requireClass);
    }


    /**
     * 为指定的Key的数值递增相应的delta, 原值必须为Long型
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param key    对象key(必要)
     * @param delta  递增的值
     */
    @Override
    public Long increment(String appkey, String key, long delta) {

        return redisTemplate.opsForValue().increment(combineKey(appkey, key), delta);
    }


    /**
     * 设定指定的键值的过期时长
     *
     * @param appkey  应用模块的固定key部分(必要)
     * @param key     对象key(必要)
     * @param timeout 超时时长(单位：秒)
     * @return 设置成功返回true, 否则false
     * @author zejun.dong
     * @Date 2017年11月15日上午10:44:16
     */
    @Override
    public Boolean expire(String appkey, String key, final long timeout) {

        return redisTemplate.expire(combineKey(appkey, key), timeout, TimeUnit.SECONDS);
    }


    /**
     * 设定指定的键值的过期时长
     *
     * @param appkey 应用模块的固定key部分(必要)
     * @param key    对象key(必要)
     * @param date   超时时间
     * @return 设置成功返回true, 否则false
     * @author zejun.dong
     * @Date 2017年11月15日上午10:44:16
     */
    @Override
    public Boolean expireAt(String appkey, String key, final Date date) {

        return redisTemplate.expireAt(combineKey(appkey, key), date);
    }

    /*
     * 获取当前的组合key
     */
    private String combineKey(String appkey, String key) {

        return String.format("%s-%s", appkey, key);
    }

    private String serialize(V value) {

        return JSON.toJSONString(value);
    }

    private V deserialize(String value, Class<? extends V> requireClass) {

        return JSON.parseObject(value, requireClass);
    }
}