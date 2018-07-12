/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RabbitConfig
 * Author:   user
 * Date:     2018/7/11 15:59
 * Description: MQ配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.authenticationservice.util.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈MQ配置类〉
 *
 * @author user
 * @create 2018/7/11
 * @since 1.0.0
 */
@Configuration
public class RabbitConfig {
    @Value("${exchange}")
    private String exchange;
    @Value("${routeKey}")
    private String routeKey;
    @Bean
    TopicExchange exchangeDeclare() {
        return new TopicExchange(exchange);
    }
    @Bean
    Queue queueDeclare(){
        return new Queue(routeKey);
    }
    @Bean
    Binding bindingExchangeMessage(Queue queueDeclare, TopicExchange exchangeDeclare) {
        return BindingBuilder.bind(queueDeclare).to(exchangeDeclare).with(routeKey);
    }
}