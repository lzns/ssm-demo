<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试json数据格式类型的数据的传递</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/js/testJson.js"></script>
</head>
<body>
	<h2 align="center">本页面进行json数据传输测试</h2>
	<form action="" >
		<input type="button" value="测试1后台返回对象" onclick="test1();"/>
		<input type="button" value="测试2后台返会字符串" onclick="test2();"/>
		<input type="button" value="测试eval函数返回json对象" onclick="test3();"/>
		<input type="button" value="测试前台json数据传到后台" onclick="test4();"/>
		<input type="button" value="测试自定义消息转换器" onclick="test6();"/>
	</form>
</body>
</html>