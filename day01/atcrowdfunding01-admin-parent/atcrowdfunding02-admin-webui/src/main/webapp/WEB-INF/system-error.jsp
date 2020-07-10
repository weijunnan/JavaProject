<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>出错了！</h1>
	
	<!-- 从请求域取出Exception对象，再进一步访问message属性就能够显示错误消息 -->
	${requestScope.exception.message }

</body>
</html>