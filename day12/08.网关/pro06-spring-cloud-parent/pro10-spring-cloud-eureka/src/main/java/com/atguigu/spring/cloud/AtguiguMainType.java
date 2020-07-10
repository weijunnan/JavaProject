package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启用Eureka服务器端功能
@EnableEurekaServer
@SpringBootApplication
public class AtguiguMainType {
	
	public static void main(String[] args) {
		SpringApplication.run(AtguiguMainType.class, args);
	}

}
