<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试json数据格式类型的数据的传递</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
function test1(){
	$.ajax({
		type:'post',
		url:'json/test1',
		datatype:'josn',
		success:function(text){
			/*var code = text.code;
			var desc = text.desc;
			alert(code+desc);
			var obj = text.data;
			alert(obj.name + obj.age);
			var str = JSON.stringify(text);
			alert(str);*/
			alert(text);
			for (var i = 0;i<text.length;i++){
			    var name = text[i].name;
			    var age = text[i].age;
			    alert(name + ":" + age);
            }

		},
		error:function(data){
			alert("后台发生异常，请联系管理员！");
		},
		asyn:false,
		cache:false
	});
}
function test2(){
	$.ajax({
		type:'post',
		url:'json/test2',
		datatype:'json',
		success:function(text){
			alert(text);
			alert(text.code+text.desc);
		},
		error:function(text){
			alert("后台发生异常！");
		},
		asyn:false,
		cache:false 
	});
}
function test3(){
	var json = '{"name":"李四","age":"23"}';
	var $json = eval("("+json+")");
	alert(typeof($json));//object
	alert($json.name);//李四
}
function test4(){
	$.ajax({
		type:'post',
		url:'json/test4',
		datatype:'json',
		data:{name:"丁振锋",age:"323"},
		success:function(text){
			if(text!=null){
				alert(typeof(text));
				alert(text.desc);
			}
		},
		error:function(text){
			alert("后台发生异常！");
		},
		asyn:false,
		cache:false
	});
}
function test6(){
	$.ajax({
		type:'post',
		url:'json/test6',
		contentType:'application/x-result',
		data:{code:"200",desc:"我是丁振锋"},
		success:function(text){
			alert(text);
		},
		error:function(data){
			alert("后台异常！")
		},
		asyn:false,
		cache:false
	});


}
</script>
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