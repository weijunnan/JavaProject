package com.atguigu.crowd.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.ParamData;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;

@Controller
public class TestHandler {
	
	@Autowired
	private AdminService adminService;
	
	private Logger logger = LoggerFactory.getLogger(TestHandler.class);
	
	@ResponseBody
	@RequestMapping("/send/compose/object.json")
	public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student, HttpServletRequest request) {
		
		boolean judgeResult = CrowdUtil.judgeRequestType(request);
		
		logger.info("judgeResult="+judgeResult);
		
		logger.info(student.toString());
		
		// 将“查询”到的Student对象封装到ResultEntity中返回
		ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);
		
		String a = null;
		
		System.out.println(a.length());
		
		return resultEntity;
	}
	
	@ResponseBody
	@RequestMapping("/send/array/three.html")
	public String testReceiveArrayThree(@RequestBody List<Integer> array) {
		
		for (Integer number : array) {
			logger.info("number="+number);
		}
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/send/array/two.html")
	public String testReceiveArrayTwo(ParamData paramData) {
		
		List<Integer> array = paramData.getArray();
		
		for (Integer number : array) {
			System.out.println("number="+number);
		}
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/send/array/one.html")
	public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
		
		for (Integer number : array) {
			System.out.println("number="+number);
		}
		
		return "success";
	}
	
	@RequestMapping("/test/ssm.html")
	public String testSsm(ModelMap modelMap, HttpServletRequest request) {
		
		boolean judgeResult = CrowdUtil.judgeRequestType(request);
		
		logger.info("judgeResult="+judgeResult);
		
		List<Admin> adminList = adminService.getAll();
		
		modelMap.addAttribute("adminList", adminList);
		
		String a = null;
		
		System.out.println(a.length());
		
		return "target";
	}

}
