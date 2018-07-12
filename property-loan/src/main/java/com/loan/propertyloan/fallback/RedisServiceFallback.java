/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RedisServiceFallback
 * Author:   user
 * Date:     2018/7/6 14:57
 * Description: RedisServiceFallBack
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.fallback;

import com.loan.redis.RedisService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈RedisServiceFallBack〉
 *
 * @author user
 * @create 2018/7/6
 * @since 1.0.0
 */
//@Component
public class RedisServiceFallback implements RedisService{

    @Override
    public String getRedis() {
        return "error";
    }
}