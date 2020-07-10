package com.atguigu.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {
	
	public static void main(String[] args) {
		
		// 1.创建BCryptPasswordEncoder对象
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// 2.准备明文字符串
		String rawPassword = "123123";
		
		// 3.加密
		String encode = passwordEncoder.encode(rawPassword);
		System.out.println(encode);
		// $2a$10$3YODojJmtbcOzHqB6bjZhO2CR7l9pPDfxBsnYz2voBHw5Ro.5bMAm
		// $2a$10$UeZXBF9bPMipZuFp0djjj.vnShI2J097JtgGHAZX5mtJ49FMiP6XK
		// $2a$10$ucdma3RFSGVgNc30nGxu9Oku66A4zHNbaxTgxRq4ucpbw7ZmeK.8m
		// $2a$10$kpGqUaCvRGA5rE0.GNyvGugHBPZPM8bKQ96KJl9vxyx/N3bif72OS
		// $2a$10$MSDMkdzhHGIj8o6A7RUa7Oe3Iww13jy7IQRCEG.aOJa6/uI2U/Pem
	}

}

class EncodeTest {
	
	public static void main(String[] args) {
		
		// 1.准备明文字符串
		String rawPassword = "123123";
		
		// 2.准备密文字符串
		String encodedPassword = "$2a$10$ucdma3RFSGVgNc30nGxu9Oku66A4zHNbaxTgxRq4ucpbw7ZmeK.8m";
		
		// 3.创建BCryptPasswordEncoder对象
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// 4.比较
		boolean matcheResult = passwordEncoder.matches(rawPassword, encodedPassword);
		
		System.out.println(matcheResult ? "一致" : "不一致");
	}
	
}

