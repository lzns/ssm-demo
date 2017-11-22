<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传第一种 servlet3.0 以下</title>
<script src="static/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
function load(){
	alert("试试。。。");
}
	//文件上传使用ajax
	function fileupload(){
		$.ajax({
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
		});
	
	}

</script>
<body onload="load()">
<h1>第一种 ，fileUpload的实现方式</h1>
<form  id ="form1" action="load/upload1" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file1' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button1" value="ajax上传" onclick="fileupload()">
	<input type ="submit" value="直接上传">
</form> 
<hr>

<h1>第二种，part的实现方式</h1>
<form  id ="form2" action="load/upload2" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file2' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button2" value="ajax上传" onclick="fileupload2()">
	<input type ="submit" value="直接上传">
</form> 

</body>
</html>