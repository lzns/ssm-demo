<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${ctx}/static/bootstrap/bootstrap.min.css" />
<script src="${ctx}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap/popper.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	//检查两次输入的密码是否一致
	function checkPassword() {
		var password = $("#password").val();
		var password2 = $("#password2").val();
		if (password.length > 0) {
			if (password2.length <= 0) {
				alert("请输入密码！");
				$("#password2").focus();
				return;
			}
			if (password2 != password) {
				alert("两次输入的密码不一致，请重新输入！！！");
				$("#password2").val('');
				$("#password2").focus();
			}
		}
	}
	function save() {
		alert("准备注册了。。。");
		$.ajax({
			url : '${ctx}/user/register',
			type : 'post',
			data : $("#from").serialize(),
			success : function(info) {
				if(info.code=="666"){
					alert(info.desc);
					setTimeout(function() {
						window.location.href=info.url;
					}, 3000);
				}
			},
			error : function(info) {
				alert("后台发生异常，请联系管理人员！");
			},
			async : false,
			cache : false
		});
	}
</script>
<title>注册页面</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" id="from" method="post"
			action="user/register">
			<div class="form-group">
				<label for="login_name" class="col-sm-2 control-label">登录名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="login_name"
						name="login_name" placeholder="login_name">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="name">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="password" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="password2" class="col-sm-2 control-label">确认密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password2"
						name="password2" placeholder="confirm password"
						onblur="checkPassword();" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="organization_id" class="col-sm-2 control-label">所属部门</label>
				<div class="col-sm-10">
					<select class="form-control" id="organization_id"
						name="organization_id">
						<option value="3">技术部</option>
						<option value="1">总经办</option>
						<option value="5">产品部</option>
						<option value="6">测试组</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-10">
					<div class="radio">
						<label> <input type="radio" name="sex" id="sex" value="0">
							女
						</label> <label> <input type="radio" name="sex" id="sex" value="1">
							男
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="age" class="col-sm-2 control-label">年龄</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="age" name="age"
						placeholder="age">
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">手机号码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" name="phone"
						placeholder="phone">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-6">
					<button type="button" class="btn btn-primary" onclick="save();">注册</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>