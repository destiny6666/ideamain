/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisTest
 * Author:   user
 * Date:     2018/7/4 15:25
 * Description: redis测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice;

import com.loan.redisservice.config.IRedisClientKValue;
import com.loan.redisservice.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈redis测试〉
 *
 * @author user
 * @create 2018/7/4
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private IRedisClientKValue iRedisClientKValue;

    @Before
    public void beforeUser() {
        for(int k=1;k<10;k++){
            iRedisClientKValue.delete("test","User:"+k);
        }
//        Type type = new TypeToken<User>() {}.getType();
        Object getU=iRedisClientKValue.get("test","User:"+1,User.class);
        System.out.println(getU);
        for(int k=1;k<10;k++){
            User user = new User(k,"张"+k,true,new Date());
            iRedisClientKValue.set("test","User:"+k,user);
        }
    }

    @Test
    public void redisTest() {
        for(int k=1;k<10;k++){
            Object getU=iRedisClientKValue.get("test","User:"+k,User.class);
            System.out.println(getU);
        }
    }
}