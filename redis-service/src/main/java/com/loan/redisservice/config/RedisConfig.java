/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisConfig
 * Author:   user
 * Date:     2018/7/4 14:12
 * Description: RedisTemplate初始化
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈RedisTemplate初始化〉
 *
 * @author user
 * @create 2018/7/4
 * @since 1.0.0
 */
@Configuration
public class RedisConfig {
public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
    StringRedisTemplate template=new StringRedisTemplate(factory);
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om=new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.afterPropertiesSet();
    return  template;
    }
}