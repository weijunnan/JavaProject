package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.vo.ProjectVO;

public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);

}
