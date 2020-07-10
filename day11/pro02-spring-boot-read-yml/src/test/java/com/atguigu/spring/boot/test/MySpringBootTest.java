package com.atguigu.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.spring.boot.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBootTest {
	
	Logger logger = LoggerFactory.getLogger(MySpringBootTest.class);
	
	@Autowired
	private Student student;
	
	@Value("${atguigu.best.wishes}")
	private String wishes;
	
	@Test
	public void testReadSimpleValue() {
		logger.debug(wishes);
	}
	
	@Test
	public void testReadYaml() {
		
		logger.info(student.toString());
		
	}

}
