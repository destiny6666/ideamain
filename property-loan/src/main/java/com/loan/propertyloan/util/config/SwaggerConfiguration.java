package com.loan.propertyloan.util.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by max on 8/16/16.
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	 @Bean
	 public Docket buildDocket(){
	  return new Docket(DocumentationType.SWAGGER_2)
	    .apiInfo(buildApiInf())
	    .select()
	    .apis(RequestHandlerSelectors.basePackage("com.loan.propertyloan.core.controller"))
	    .paths(PathSelectors.any())
	    .build();
	 }
	 
	 private ApiInfo buildApiInf(){
	  return new ApiInfoBuilder()
	     .title("普惠时代APP")
	     .description("接口文档")
	     .contact(new Contact("加密工具地址", "http://192.168.100.161:8888/creditAPP/html/puhuiH5/加解密转换Test.html", null))
	     .build();
	 
	 }
}