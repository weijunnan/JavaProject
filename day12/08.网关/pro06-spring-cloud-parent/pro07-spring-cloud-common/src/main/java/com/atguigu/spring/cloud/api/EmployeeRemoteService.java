package com.atguigu.spring.cloud.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.spring.cloud.entity.Employee;
import com.atguigu.spring.cloud.factory.MyFallBackFactory;
import com.atguigu.spring.cloud.util.ResultEntity;

// @FeignClient注解表示当前接口和一个Provider对应
// 		注解中value属性指定要调用的Provider的微服务名称
// 		注解中fallbackFactory属性指定Provider不可用时提供备用方案的工厂类型
@FeignClient(value = "atguigu-provider", fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
	
	// 远程调用的接口方法
	// 要求@RequestMapping注解映射的地址一致
	// 要求方法声明一致
	// 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody不能省略，两边一致
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote();

	@RequestMapping("/provider/get/emp/list/remote")
	public List<Employee> getEmpListRemote(String keyword);
	
	@RequestMapping("/provider/get/emp/with/circuit/breaker")
	public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);

}
