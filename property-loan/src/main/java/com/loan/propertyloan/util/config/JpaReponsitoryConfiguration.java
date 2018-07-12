/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: JpaReponsitoryConfiguration
 * Author:   user
 * Date:     2018/7/3 15:38
 * Description: Jpa配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.util.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Jpa配置类〉
 *
 * @author user
 * @create 2018/7/3
 * @since 1.0.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.loan.propertyloan.Repository")
@EntityScan(basePackages = "com.loan.propertyloan.entity")
public class JpaReponsitoryConfiguration {
@Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
    return new PersistenceExceptionTranslationPostProcessor();
}
}