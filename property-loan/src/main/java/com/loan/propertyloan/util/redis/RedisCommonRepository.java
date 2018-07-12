/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisCommonRepository
 * Author:   user
 * Date:     2018/7/4 15:16
 * Description: Redis共用Repository
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.util.redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈Redis共用Repository〉
 *
 * @author user
 * @create 2018/7/4
 * @since 1.0.0
 */
@Repository
public class RedisCommonRepository {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public <T> T add(String key, Long time, T t) {
        Gson gson=new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(t),time,TimeUnit.MINUTES);
        return t;
    }
    public <T> T get(String key, Type type){
        System.out.println(type.toString());
        Gson gson=new Gson();
        T o=null;
        String objectJson=redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(objectJson)){
            o=gson.fromJson(objectJson,type);
        }
        System.out.println("======"+o.toString());
        return o;
    }
}