package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 下面两个注解功能大致相同
// @EnableDiscoveryClient	启用发现服务功能，不局限于Eureka注册中心
// @EnableEurekaClient		启用Eureka客户端功能，必须是Eureka注册中心
@SpringBootApplication
public class AtguiguMainType {
	
	public static void main(String[] args) {
		SpringApplication.run(AtguiguMainType.class, args);
	}

}
