package com.atguigu.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 注意！这个类一定要放在自动扫描的包下，否则所有配置都不会生效！

// 将当前类标记为配置类
@Configuration

// 启用Web环境下权限控制功能
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security
			.authorizeRequests()			// 对请求进行授权
			.antMatchers("/index.jsp")		// 针对/index.jsp路径进行授权
			.permitAll()					// 可以无条件访问
			.antMatchers("/layui/**")		// 针对/layui目录下所有资源进行授权
			.permitAll()					// 可以无条件访问
			.and()
			.authorizeRequests()			// 对请求进行授权
			.anyRequest()					// 任意请求
			.authenticated()				// 需要登录以后才可以访问
			.and()
			.formLogin()					// 使用表单形式登录
			
			// 关于loginPage()方法的特殊说明
			// 指定登录页的同时会影响到：“提交登录表单的地址”、“退出登录地址”、“登录失败地址”
			// /index.jsp GET - the login form 去登录页面
			// /index.jsp POST - process the credentials and if valid authenticate the user 提交登录表单
			// /index.jsp?error GET - redirect here for failed authentication attempts 登录失败
			// /index.jsp?logout GET - redirect here after successfully logging out 退出登录
			.loginPage("/index.jsp")		// 指定登录页面（如果没有指定会访问SpringSecurity自带的登录页）
			
			// loginProcessingUrl()方法指定了登录地址，就会覆盖loginPage()方法中设置的默认值/index.jsp POST
			.loginProcessingUrl("/do/login.html")	// 指定提交登录表单的地址
			;
		
	}

}
