<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传第一种 servlet3.0 以下</title>
<script  type="text/javascript" src="static/js/jquery.min.js"></script>
<script  type="text/javascript" src="static/js/jquery.form.js"></script>
</head>
<script type="text/javascript">
function fileupload1(){
		$("#form2").ajaxSubmit();
		/* var formData = new FormData($("#form1")[0]);
		$.ajax({
			url:'load/upload2',
			type:'post',
			data:formData,
            //必须false才会自动加上正确的Content-Type
			contentType: false,
			//必须false才会避开jQuery对 formdata 的默认处理
            //XMLHttpRequest会对 formdata 进行正确的处理
			processData: false,
			success:function(data){
				alert(data);
			},
			error:function(data){
				alert(data);
				alert("后台发生异常");
			},
			cache:false,
			async:true
		});  */
}
function fileupload2(){
	var formData = new FormData($("#form2")[0]);
	$.ajax({
			url:'load/upload2',
			type:'post',
			data:formData,
            //必须false才会自动加上正确的Content-Type
			contentType: false,
			//必须false才会避开jQuery对 formdata 的默认处理
            //XMLHttpRequest会对 formdata 进行正确的处理
			processData: false,
			success:function(data){
				alert(data);
			},
			error:function(data){
				alert(data);
				alert("后台发生异常");
			},
			cache:false,
			async:true
		}); 
}
function fileupload3(){
	var formData = new FormData($("#form5")[0]);
		$.ajax({
				url:'load/upload3',
				type:'post',
				data:formData,
	            //必须false才会自动加上正确的Content-Type
				contentType: false,
				//必须false才会避开jQuery对 formdata 的默认处理
	            //XMLHttpRequest会对 formdata 进行正确的处理
				processData: false,
				success:function(data){
					alert(data);
				},
				error:function(data){
					alert(data);
					alert("后台发生异常");
				},
				cache:false,
				async:true
			}); 
}
function fileupload4(){
	var formData = new FormData($("#form6")[0]);
		$.ajax({
				url:'load/upload4',
				type:'post',
				data:formData,
	            //必须false才会自动加上正确的Content-Type，不要处理发送的数据
				contentType: false,
				//必须false才会避开jQuery对 formdata 的默认处理,不要设置请求头
	            //XMLHttpRequest会对 formdata 进行正确的处理
				processData: false,
				success:function(data){
					alert(data);
				},
				error:function(data){
					alert(data);
					alert("后台发生异常");
				},
				cache:false,
				async:true
			}); 

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

<h1>第二种，ssm使用CommonsMultipartFile上载的的实现方式</h1>
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
<form action="load/down2" name="form4" id = "form4" method="post">
	<input type = "submit" value="压缩文件下载">
</form>
<h1>多文件上传</h1>
<form  id ="form5" action="load/upload3" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file' />
	<input type = "file" name= 'file' />
	<input type = "file" name= 'file' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button2" value="多文件ajax上传" onclick="fileupload3()">
	<input type ="submit" value="多文件直接上传">
</form> 
<h1>单文件上传使用MultiPartFile</h1>
<form  id ="form6" action="load/upload4" enctype="multipart/form-data" method="post">
	<input type = "file" name= 'file' />
	<input type="text" name="name" value="dzf"/>
	<input type="button" id = "button2" value="ajax上传" onclick="fileupload4()">
	<input type ="submit" value="直接上传">
</form> 
</body>
</html>