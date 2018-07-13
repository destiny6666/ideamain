/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisImpController
 * Author:   user
 * Date:     2018/7/5 17:00
 * Description: API实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice;


import com.alibaba.fastjson.JSON;
import com.loan.redisservice.config.IRedisClientKValue;
import com.loan.redisservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import redis.RedisService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈API实现〉
 *
 * @author user
 * @create 2018/7/5
 * @since 1.0.0
 */
@RestController
public class RedisImpController implements RedisService {
    @Autowired
    private IRedisClientKValue iRedisClientKValue;

    @Override
    public String getRedis() {
//        for(int k=1;k<10;k++){
//            User user = new User(k,"张"+k,true,new Date());
//            iRedisClientKValue.set("test","User:"+k,user);
//        }
//        List<Object> objectList=new ArrayList<Object>();
//        for(int k=1;k<10;k++){
//            Object getU=iRedisClientKValue.get("test","User:"+k,User.class);
//            objectList.add(getU);
//            System.out.println(getU);
//        }
        List<Object> objectList = new ArrayList<Object>();
        for (int k = 1; k < 10; k++) {
            User user = new User(k, "张" + k, true, new Date());
            objectList.add(user);
        }
        return JSON.toJSONString(objectList);
    }
}