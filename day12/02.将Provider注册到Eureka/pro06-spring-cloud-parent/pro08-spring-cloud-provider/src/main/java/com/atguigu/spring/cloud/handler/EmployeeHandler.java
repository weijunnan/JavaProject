package com.atguigu.spring.cloud.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class EmployeeHandler {
	
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote() {
		return new Employee(555, "tom555", 555.55);
	}

}
