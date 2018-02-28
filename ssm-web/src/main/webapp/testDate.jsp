<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试时间类型的数据传输到后台</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
function test1(){
	$.ajax({
		type:'post',
		url:'json/test1',
		datatype:'josn',
		success:function(text){
			var code = text.code;
			var desc = text.desc;
			alert(code+desc);
			var obj = text.data;
			alert(obj.name + obj.age);
			var str = JSON.stringify(text);
			alert(str);
		},
		error:function(data){
			alert("后台发生异常，请联系管理员！");
		},
		asyn:false,
		cache:false
	});
  }
function test2(){
		alert("2秒后跳转到另一个页面");
		setTimeout(function() {
			window.location.href="${ctx}/testJson.jsp";
		}, 2000);
	
	}
</script>
<body>
	<h2 align="center">本页面进行日期格式数据传输测试</h2>
	<form action="json/test5" method="post">
		<input type="date" name="birthday" id="birthday"/>
		<input type="text" name="code" />
		<input type="text" name="desc" />
		<input type="submit" value="提交" />
	<hr>	
	<h2>
		<input type="button" onclick="test2();" value="测试定时器">
	</h2>
	</form>
</body>
</html>