package com.atguigu.crowd.test;

import com.atguigu.crowd.util.CrowdUtil;

public class StringTest {
	
	// @Test
	public void testMd5() {
		String source = "123123";
		String encoded = CrowdUtil.md5(source);
		System.out.println(encoded);
	}
	
	// @Test
	public void testSync() {
		method01();
	}
	
	public void method01() {
		System.out.println("1111111111开始");
		method02();
		System.out.println("1111111111结束");
	}
	
	public void method02() {
		System.out.println("2222222222开始");
		method03();
		System.out.println("2222222222结束");
	}
	
	public void method03() {
		System.out.println("3333");
	}

}