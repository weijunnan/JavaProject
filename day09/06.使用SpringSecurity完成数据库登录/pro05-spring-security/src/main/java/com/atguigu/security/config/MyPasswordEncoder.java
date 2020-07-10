package com.atguigu.security.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		return privateEncode(rawPassword);
		
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		// 1.对明文密码进行加密
		String formPassword = privateEncode(rawPassword);
		
		// 2.声明数据库密码
		String databasePassword = encodedPassword;
		
		// 3.比较
		return Objects.equals(formPassword, databasePassword);
	}
	
	private String privateEncode(CharSequence rawPassword) {
		try {
			// 1.创建MessageDigest对象
			String algorithm = "MD5";
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			
			// 2.获取rawPassword的字节数组
			byte[] input = ((String)rawPassword).getBytes();
			
			// 3.加密
			byte[] output = messageDigest.digest(input);
			
			// 4.转换为16进制数对应的字符
			String encoded = new BigInteger(1, output).toString(16).toUpperCase();
			
			return encoded;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String privateEncode = new MyPasswordEncoder().privateEncode("123123");
		System.out.println(privateEncode);
	}
}
