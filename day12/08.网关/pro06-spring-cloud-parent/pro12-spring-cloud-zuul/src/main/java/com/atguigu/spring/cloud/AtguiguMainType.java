package com.atguigu.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// 启用Zuul的网关代理功能
@EnableZuulProxy
@SpringBootApplication
public class AtguiguMainType {
	
	public static void main(String[] args) {
		SpringApplication.run(AtguiguMainType.class, args);
	}

}
