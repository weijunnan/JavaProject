package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.entity.vo.ProjectVO;

public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);
	
	List<PortalTypeVO> getPortalTypeVO();
	
	DetailProjectVO getDetailProjectVO(Integer projectId);

}
