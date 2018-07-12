/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: LoanInterceptorConfiguration
 * Author:   user
 * Date:     2018/7/11 14:15
 * Description: 拦截器config类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.util.config;

import com.loan.propertyloan.interceptor.LoanInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈拦截器config类〉
 *
 * @author user
 * @create 2018/7/11
 * @since 1.0.0
 */
@SpringBootConfiguration
public class LoanInterceptorConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private LoanInterceptor loanInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loanInterceptor).addPathPatterns("/**");
    }
}