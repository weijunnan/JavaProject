package com.atguigu.crowd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ali.pay")
@Component
public class PayProperties {
	
	private String appId;
	
	private String merchantPrivateKey;
	
	private String alipayPublicKey;
	
	private String notifyUrl;
	
	private String returnUrl;
	
	private String signType;
	
	private String charset;
	
	private String gatewayUrl;

}
