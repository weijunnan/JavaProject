package com.atguigu.spring.cloud.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class EmployeeHandler {
	
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote(HttpServletRequest request) {
		
		// 获取当前服务的端口号
		int serverPort = request.getServerPort();
		
		return new Employee(555, "tom555 "+serverPort, 555.55);
	}

}
