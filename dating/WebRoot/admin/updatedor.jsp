<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改宿舍信息</title>
    
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
    修改宿舍信息 <br>
    <table borde="1">
    	<tr>
   			<td>编号</td>
    		<td>宿舍名</td>
    		<td>删除</td>
		</tr>
		<c:forEach items="${applicationScope.arraylist}" var="a" varStatus="num">
			<tr>
				<td>${num.count}</td>
				<td>${a.name}</td>
				<td><c:url value="/dorser" var="delete">
				<c:param name="dormitory" value="${a.name}"></c:param>
				<c:param name="status" value="deletedormitory"></c:param></c:url>
				<a href="${delete}">删除</a></td>
				
			<tr>
		</c:forEach>
	</table>
  </body>
</html>
