package com.loan.authenticationservice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
import rabbitMQ.RabbitMessage;
@Component
public class RabbitMQ {
	@Resource  
    private RabbitTemplate rabbitTemplate; 
	@Value("${exchange}")
	private String exchange;
	@Value("${routeKey}")
	private String routeKey;
	public void pushMessageToMQ(String className, String methodName,String param) {
        RabbitMessage msg=new RabbitMessage(exchange,routeKey,className, methodName, param);
        try {
        	rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg);
		} catch (Exception e) {
			// TODO: handle exception
		}  
	}
	public void pushMessageToMQ(String className, String methodName,String param,String exchange,String routeKey) {
		RabbitMessage  msg=new RabbitMessage(exchange,routeKey,className, methodName, param);
        try {
        	rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg);
		} catch (Exception e) {
			// TODO: handle exception
		}  
	}
}
