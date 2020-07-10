package com.atguigu.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

// 注意！这个类一定要放在自动扫描的包下，否则所有配置都不会生效！

// 将当前类标记为配置类
@Configuration

// 启用Web环境下权限控制功能
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		builder
			.inMemoryAuthentication()	// 在内存中完成账号、密码的检查
			.withUser("tom")			// 指定账号
			.password("123123")			// 指定密码
			.roles("ADMIN","学徒")				// 指定当前用户的角色
			.and()
			.withUser("jerry")			// 指定账号
			.password("123123")			// 指定密码
			.authorities("UPDATE","内门弟子")		// 指定当前用户的权限
			;
		
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security
			.authorizeRequests()			// 对请求进行授权
			.antMatchers("/index.jsp")		// 针对/index.jsp路径进行授权
			.permitAll()					// 可以无条件访问
			.antMatchers("/layui/**")		// 针对/layui目录下所有资源进行授权
			.permitAll()					// 可以无条件访问
			.antMatchers("/level1/**")		// 针对/level1/**路径设置访问要求
			.hasRole("学徒")					// 要求用户具备“学徒”角色才可以访问
			.antMatchers("/level2/**")		// 针对/level2/**路径设置访问要求
			.hasAuthority("内门弟子")			// 要求用户具备“内门弟子”权限才可以访问
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
			.usernameParameter("loginAcct")			// 定制登录账号的请求参数名
			.passwordParameter("userPswd")			// 定制登录密码的请求参数名
			.defaultSuccessUrl("/main.html")		// 登录成功后前往的地址
//			.and()
//			.csrf()
//			.disable()								// 禁用CSRF功能
			.and()
			.logout()								// 开启退出功能
			.logoutUrl("/do/logout.html")			// 指定处理退出请求的URL地址
			.logoutSuccessUrl("/index.jsp")			// 退出成功后前往的地址
			.and()
			.exceptionHandling()					// 指定异常处理器
			// .accessDeniedPage("/to/no/auth/page.html")	// 访问被拒绝时前往的页面
			.accessDeniedHandler(new AccessDeniedHandler() {
				
				@Override
				public void handle(HttpServletRequest request, HttpServletResponse response,
						AccessDeniedException accessDeniedException) throws IOException, ServletException {
					request.setAttribute("message", "抱歉！您无法访问这个资源！☆☆☆");
					request.getRequestDispatcher("/WEB-INF/views/no_auth.jsp").forward(request, response);
				}
			})
			;
	}

}
