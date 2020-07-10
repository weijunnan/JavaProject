package com.atguigu.spring.boot.mapper;

import java.util.List;

import com.atguigu.spring.boot.entity.Emp;

public interface EmpMapper {
	
	List<Emp> selectAll();

}
