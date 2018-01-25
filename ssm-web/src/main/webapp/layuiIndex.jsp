<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开始使用layUI</title>
<link rel="stylesheet" href="static/layui/layui.css" />
<script type="text/javascript" src="static/layui/layui.all.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
</head>
<script>
	//一般直接写在一个js文件中

$(function() {
		layui.config({
   dir: '/static/layui/' //layui.js 所在路径（注意，如果是script单独引入layui.js，无需设定该参数。），一般情况下可以无视
  ,version: false //一般用于更新模块缓存，默认不开启。设为true即让浏览器不缓存。也可以设为一个固定的值，如：201610
  ,debug: false //用于开启调试模式，默认false，如果设为true，则JS模块的节点会保留在页面
  ,base: '' //设定扩展的Layui模块的所在目录，一般用于外部模块扩展
});
	});
function login(){

	alert(1111);
}	 
</script>
<body>
	<div class="layui-form">
		<form >
			<input type="text" name="name" />
			<input type="button" class="layui-btn layui-bg-red" value="点击一下" onclick="test();" />
			<button class="layui-btn" lay-filter="login">登入</button>     
		</form>
	</div>
<div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">标题一</li>
    <li>标题二</li>
    <li>标题三</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">内容1</div>
    <div class="layui-tab-item">内容2</div>
    <div class="layui-tab-item">内容3</div>
  </div>
</div>
</body>
</html>