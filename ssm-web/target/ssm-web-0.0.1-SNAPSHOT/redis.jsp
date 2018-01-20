<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="static/js/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function getKey(){
	var name=$('#name').val();
	alert(name);
		$.ajax({
		url:'redis/getKey',
		type:'post',
		data:{"key":name},
		dateType:'json',
		success:function(data){
			alert(data);
		},
		async:false,
		cache:false
		});
	/* $.ajax({
			url:"load/upload1",
			type:"post",
			data:$("#form1").serialize(),
			dataype:'json',
			success:function(data){
				alert(data);
			},
			error:function(data){
				return data;
			},
			cache:false,
			async:false
		}); */
	}
</script>
</head>
<body>
<input id="name" name= "name" type="text">
<input type="button" value="点击试试" onclick="getKey();"/>

</body>
</html>