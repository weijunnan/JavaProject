package com.atguigu.crowd.handler;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHandler {
	
	@RequestMapping("/test/spring/session/save")
	public String testSession(HttpSession session) {
		
		session.setAttribute("king", "hello-king");
		
		return "数据存入Session域！";
	}

}
