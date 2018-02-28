<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${ctx}/static/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/static/bootstrap/signin.css"  />
<script src="${ctx}/static/js/jquery.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/popper.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/bootstrap.min.js"  type="text/javascript" ></script>
<title>登录页面</title>
</head>
<script type="text/javascript">
	function login(){
		$.ajax({
			url:'${ctx}/user/login',
			data:$("#form").serialize(),
			type:'post',
			success:function(data){
				if(data.code == "666"){
					window.location.href=data.url;
				}else{
					alert(data.desc);
				}
			},
			error:function(data){
				alert("后台发生异常！");
			},
			async:false,
			cache:false
		});
	}
	$(window).keydown(function(event){
		if(event.keyCode==13){ //回车键
			login();
		}
	});
	
</script>
<body class="text-center">
	 <form class="form-signin" id="form"  method="post">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="login_name" class="sr-only">your login_name</label>
      <input type="text" id="login_name" name="login_name"  placeholder="Email address" />
      <label for="password" class="sr-only">Password</label>
      <input type="text" id="password" name="password" placeholder="Password" />
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="ok" name="rememberMe"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login();">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
    </form>
</html>