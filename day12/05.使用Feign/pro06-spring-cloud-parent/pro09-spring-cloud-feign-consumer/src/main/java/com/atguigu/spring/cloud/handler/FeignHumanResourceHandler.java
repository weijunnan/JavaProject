package com.atguigu.spring.cloud.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.api.EmployeeRemoteService;
import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class FeignHumanResourceHandler {
	
	// 装配调用远程微服务的接口，后面向调用本地方法一样直接使用
	@Autowired
	private EmployeeRemoteService employeeRemoteService;
	
	@RequestMapping("/feign/consumer/get/emp")
	public Employee getEmployeeRemote() {
		return employeeRemoteService.getEmployeeRemote();
	}
	
	@RequestMapping("/feign/consumer/search")
	public List<Employee> getEmpListRemote(String keyword) {
		
		return employeeRemoteService.getEmpListRemote(keyword);
	}

}
