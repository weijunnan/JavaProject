package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

import com.aliyun.api.gateway.demo.util.HttpUtils;
import com.atguigu.crowd.constant.CrowdConstant;

/**
 * 尚筹网项目通用工具方法类
 * @author 吴彦祖
 *
 */
public class CrowdUtil {
	
	/**
	 * 给远程第三方短信接口发送请求把验证码发送到用户手机上
	 * @param host		短信接口调用的URL地址
	 * @param path		具体发送短信功能的地址
	 * @param method	请求方式
	 * @param phoneNum	接收短信的手机号
	 * @param appCode	用来调用第三方短信API的AppCode
	 * @param sign		签名编号
	 * @param skin		模板编号
	 * @return 返回调用结果是否成功
	 * 	成功：返回验证码
	 * 	失败：返回失败消息
	 * 	状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
	 */
	public static ResultEntity<String> sendCodeByShortMessage(
			
			String host,
			
			String path,
			
			String method,
			
			String phoneNum, 
			
			String appCode, 
			
			String sign, 
			
			String skin) {
	
		Map<String, String> headers = new HashMap<String, String>();

		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appCode);

		// 封装其他参数
		Map<String, String> querys = new HashMap<String, String>();
		
		// 生成验证码
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			int random = (int) (Math.random() * 10);
			builder.append(random);
		}
		
		String code = builder.toString();

		// 要发送的验证码，也就是模板中会变化的部分
		querys.put("param", code);

		// 收短信的手机号
		querys.put("phone", phoneNum);

		// 签名编号
		querys.put("sign", sign);

		// 模板编号
		querys.put("skin", skin);
		// JDK 1.8示例代码请在这里下载： http://code.fegine.com/Tools.zip

		try {
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			
			StatusLine statusLine = response.getStatusLine();
			
			// 状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
			int statusCode = statusLine.getStatusCode();
			
			String reasonPhrase = statusLine.getReasonPhrase();
			
			if(statusCode == 200) {
				
				// 操作成功，把生成的验证码返回
				return ResultEntity.successWithData(code);
			}
			
			return ResultEntity.failed(reasonPhrase);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
		
	}
	
	/**
	 * 对明文字符串进行MD5加密
	 * @param source 传入的明文字符串
	 * @return 加密结果
	 */
	public static String md5(String source) {
		
		// 1.判断source是否有效
		if(source == null || source.length() == 0) {
		
			// 2.如果不是有效的字符串抛出异常
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		
		try {
			// 3.获取MessageDigest对象
			String algorithm = "md5";
			
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			
			// 4.获取明文字符串对应的字节数组
			byte[] input = source.getBytes();
			
			// 5.执行加密
			byte[] output = messageDigest.digest(input);
			
			// 6.创建BigInteger对象
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, output);
			
			// 7.按照16进制将bigInteger的值转换为字符串
			int radix = 16;
			String encoded = bigInteger.toString(radix).toUpperCase();
			
			return encoded;
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 判断当前请求是否为Ajax请求
	 * @param request 请求对象
	 * @return
	 * 		true：当前请求是Ajax请求
	 * 		false：当前请求不是Ajax请求
	 */
	public static boolean judgeRequestType(HttpServletRequest request) {
		
		// 1.获取请求消息头
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");
		
		// 2.判断
		return (acceptHeader != null && acceptHeader.contains("application/json"))
				
				||
				
				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}

}
