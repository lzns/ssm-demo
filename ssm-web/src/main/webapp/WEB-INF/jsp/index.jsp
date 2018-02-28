<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>秦红霞养猪网主页</title>
</head>
<body>
	<shiro:guest>
		您当前是游客，<a href="/user/login">请登录</a>
	</shiro:guest>
	<!-- 已认证，或者是rememberme  -->
	<shiro:user>  
	欢迎[<shiro:principal property="login_name"/>]登录，<a href="${ctx}/user/logout">退出</a>  
	</shiro:user> 
	<!-- 已认证，排除rememberMe的 -->
	<%-- <shiro:authenticated>
		欢迎[<shiro:principal property="username"/>]登录，<a href="/user/logout">退出</a>  
	</shiro:authenticated> --%>
	
</body>
</html>