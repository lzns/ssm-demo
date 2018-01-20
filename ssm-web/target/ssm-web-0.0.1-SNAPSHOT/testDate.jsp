<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

</script>
<body>
	<h2 align="center">本页面进行日期格式数据传输测试</h2>
	<form action="json/test5" method="post">
		<input type="date" name="birthday" id="birthday"/>
		<input type="text" name="code" />
		<input type="text" name="desc" />
		<input type="submit" value="提交" />
	</form>
</body>
</html>