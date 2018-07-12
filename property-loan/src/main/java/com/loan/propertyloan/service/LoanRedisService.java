/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: LoanRedisService
 * Author:   user
 * Date:     2018/7/6 14:09
 * Description: loanPropertyLoan继承API实现接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.service;

import com.loan.redis.RedisService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈loanPropertyLoan继承API实现接口〉
 *
 * @author user
 * @create 2018/7/6
 * @since 1.0.0
 */
@FeignClient(value = "redis-service")
public interface LoanRedisService extends RedisService {
}