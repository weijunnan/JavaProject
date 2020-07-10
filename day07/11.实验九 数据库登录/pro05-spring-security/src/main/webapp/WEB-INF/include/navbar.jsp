<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="layui-header">
	<div class="layui-logo" onclick="location.href='${PATH }/main.html'">武林秘籍管理系统</div>
	<!-- 头部区域（可配合layui已有的水平导航） -->
	<ul class="layui-nav layui-layout-left">
		<li class="layui-nav-item"><a href="">控制台</a></li>
		<li class="layui-nav-item"><a href="">商品管理</a></li>
		<li class="layui-nav-item"><a href="">用户</a></li>
		<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="">邮件管理</a>
				</dd>
				<dd>
					<a href="">消息管理</a>
				</dd>
				<dd>
					<a href="">授权管理</a>
				</dd>
			</dl></li>
	</ul>
	<ul class="layui-nav layui-layout-right">
		<li class="layui-nav-item"><a href="javascript:;"> <img
				src="http://t.cn/RCzsdCq" class="layui-nav-img"> 张无忌
		</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="">基本资料</a>
				</dd>
				<dd>
					<a href="">安全设置</a>
				</dd>
			</dl></li>
		<li class="layui-nav-item">
			<!-- 禁用CSRF功能的前提下，最简单的退出操作 -->
			<%-- <a href="${pageContext.request.contextPath }/do/logout.html">退出</a> --%>
			<form id="logoutForm" action="${pageContext.request.contextPath }/do/logout.html" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<a id="logoutAnchor" href="">退出</a>
			<script type="text/javascript">
				window.onload = function() {
					
					// 给超链接的DOM对象绑定单击响应函数
					document.getElementById("logoutAnchor").onclick = function() {
						
						// 提交包含csrf参数的表单
						document.getElementById("logoutForm").submit();
						
						// 取消超链接的默认行为
						return false;
						
					};
					
				};
			</script>
		</li>
	</ul>
</div>