package com.atguigu.spring.cloud.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.spring.cloud.entity.Employee;

@RestController
public class EmployeeHandler {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);
	
	@RequestMapping("/provider/get/emp/list/remote")
	public List<Employee> getEmpListRemote(String keyword) {
		
		logger.info("keyword="+keyword);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(33, "empName33", 333.33));
		empList.add(new Employee(44, "empName44", 444.44));
		empList.add(new Employee(55, "empName55", 555.55));
		
		return empList;
	}
	
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote() {
		
		return new Employee(555, "tom555 ", 555.55);
	}
	
//	@RequestMapping("/provider/get/employee/remote")
//	public Employee getEmployeeRemote(HttpServletRequest request) {
//		
//		// 获取当前服务的端口号
//		int serverPort = request.getServerPort();
//		
//		return new Employee(555, "tom555 "+serverPort, 555.55);
//	}

}
