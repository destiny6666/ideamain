package com.loan.regloginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RegloginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegloginServiceApplication.class, args);
    }
}
