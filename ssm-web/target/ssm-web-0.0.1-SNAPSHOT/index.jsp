<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function sub(){
		document.form2.submit();
	}
</script>
<body>
	<form name="form1" action="ssm/hello" method="get">
	<input type="text" name="str"/>
	<input type="submit" value="点击试试"/>
	</form>
	
	<form name="form2" action="ssm/add" method = "post">
		主键：<input type="text" name="id"/>
		姓名：<input type="text" name="name" />
		状态：<input type="text" name="str" />
		年龄：<input type="text" name="age" />
		<input type="button" value="提交" onclick="sub()"/>
	</form>
</body>
</html>