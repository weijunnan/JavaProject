package com.atguigu.spring.boot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.spring.boot.entity.Emp;
import com.atguigu.spring.boot.mapper.EmpMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
	
	@Autowired
	private EmpMapper empMapper;
	
	private Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Test
	public void testMapper() {
		List<Emp> list = empMapper.selectAll();
		for (Emp emp : list) {
			logger.debug(emp.toString());
		}
	}

}
