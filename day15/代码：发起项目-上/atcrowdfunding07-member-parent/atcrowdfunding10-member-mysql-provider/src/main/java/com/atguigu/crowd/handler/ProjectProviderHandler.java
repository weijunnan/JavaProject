package com.atguigu.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crowd.service.api.ProjectService;

@RestController
public class ProjectProviderHandler {
	
	@Autowired
	private ProjectService projectService;

}
