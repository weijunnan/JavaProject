package com.atguigu.spring.boot.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHandler {
	
	@RequestMapping("/get/spring/boot/hello/message")
	public String getMessage() {
		return "first blood!!!☆☆☆";
	}

}
