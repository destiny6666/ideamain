/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: LoanPropertyController
 * Author:   user
 * Date:     2018/7/6 14:17
 * Description: redisController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.controller;

import com.loan.propertyloan.service.LoanRedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redisController〉
 *
 * @author user
 * @create 2018/7/6
 * @since 1.0.0
 */
@RestController
public class LoanPropertyController {
    @Resource
    private LoanRedisService loanRedisService;
    @RequestMapping("/controllerGetRedis")
    public  String getRedis(){
        String s=loanRedisService.getRedis();
        return "原始数据："+s;
    }

}