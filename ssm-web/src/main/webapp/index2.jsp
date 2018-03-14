<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/4
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<script type="text/javascript">
    //跳转到主页
    function toMain(){
        window.location.href="${ctx}/user/main";
    }
</script>
<body onload="toMain();">
</body>
</html>
