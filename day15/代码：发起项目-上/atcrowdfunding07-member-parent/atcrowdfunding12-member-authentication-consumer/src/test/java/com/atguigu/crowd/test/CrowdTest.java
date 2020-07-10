package com.atguigu.crowd.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aliyun.api.gateway.demo.util.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdTest {
	
	private Logger logger = LoggerFactory.getLogger(CrowdTest.class);
	
	@Test
	public void testSendMessage() {
		// 短信接口调用的URL地址
		String host = "https://feginesms.market.alicloudapi.com";

		// 具体发送短信功能的地址
		String path = "/codeNotice";

		// 请求方式
		String method = "GET";

		// 登录到阿里云进入控制台找到已购买的短信接口的AppCode
		String appcode = "61f2eaa3c43e42ad82c26fbbe1061311";

		Map<String, String> headers = new HashMap<String, String>();

		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);

		// 封装其他参数
		Map<String, String> querys = new HashMap<String, String>();

		// 要发送的验证码，也就是模板中会变化的部分
		querys.put("param", "9999");

		// 收短信的手机号
		querys.put("phone", "132455553333155");

		// 签名编号
		querys.put("sign", "151003");

		// 模板编号
		querys.put("skin", "84683");
		// JDK 1.8示例代码请在这里下载： http://code.fegine.com/Tools.zip

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 或者直接下载： http://code.fegine.com/HttpUtils.zip 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 * 相关jar包（非pom）直接下载： http://code.fegine.com/aliyun-jar.zip
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			
			StatusLine statusLine = response.getStatusLine();
			
			// 状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
			int statusCode = statusLine.getStatusCode();
			logger.info("code="+statusCode);
			
			String reasonPhrase = statusLine.getReasonPhrase();
			logger.info("reason="+reasonPhrase);
			
			// System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
			// 获取response的body
			logger.info(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
