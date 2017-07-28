<!-- jsp的声明 --,这个语句是用来拼装当前网页的相对路径的>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
  <%

   %>
  	
     <form action="/dating/dorser" method="post">
     	添加新宿舍 <a href="updatedor.jsp">查询与更新</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回</a> <br>
     	新宿舍名:<input type="text" name="dormitory"><br>
  		<input type="submit" value="submit" style="color:red">
     
     	<input type="hidden" name="status" value="insertdormitory">
	</form>
  </body>
  
</html>
