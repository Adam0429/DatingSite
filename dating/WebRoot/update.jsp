<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Update <br>
 	<form action="/dating/myser" method="post">
 		账号:<%=request.getParameter("account") %><br>
     	昵称:<input type="text" name="name" value="<%=request.getParameter("name")%>" style="width: 238px; "><br>
     	手机号:<input type="text" name="tele"><br>
     	密码:<input type="text" name="password"><br>
  		<input type="submit" value="update" style="color:red"><!-- type=text是明文显示，password是密文显示,还有等等.....相当于java的api吧 -->
     	<input type="hidden" name="status" value="update">	
     	<input type="hidden" name="account" value="<%=request.getParameter("account")%>">
  </body>
</html>
