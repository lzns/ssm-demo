<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传第一种 servlet3.0 以下</title>
<script  type="text/javascript" src="static/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
function fileupload1(){
	$("#form1").ajaxSubmit();

		//var form = new FormData($("#form1"));
		/* var form = new FormData(document.getElementById("form1"));
		$.ajax({
			url:"load/upload1",
			type:"post",
			data:form,
			success:function(data){
				alert(data);
			},
			error:function(data){
				alert("后台发生异常");
			},
			cache:false,
			async:false
		}); */
}
function fileupload2(){


}
</script>
<body >
<h1>第一种 ，fileUpload的实现方式</h1>
<form  id ="form1" action="load/upload1" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button1" value="ajax上传" onclick="fileupload1()">
	<input type ="submit" value="直接上传">
</form> 
<hr>

<h1>第二种，part的实现方式</h1>
<form  id ="form2" action="load/upload2" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button2" value="ajax上传" onclick="fileupload2()">
	<input type ="submit" value="直接上传">
</form> 
<h1>普通文件下载</h1>
<form action="load/down1" name="form3" id = "form3" method="post">
	<input type = "submit" value="普通文件下载">
</form>
<h1>压缩文件下载</h1>
<form action="load/down2" name="form3" id = "form3" method="post">
	<input type = "submit" value="压缩文件下载">
</form>
</body>
</html>