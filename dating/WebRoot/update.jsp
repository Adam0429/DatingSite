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
  
  <body style="width: 503px; ">
    Update 
 	<form action="/dating/myser" method="post">
 		账号:${param.account}<br>
     	昵称:<input type="text" name="name" value="${param.name}"><br>
     	手机号:<input type="text" name="tele" value="${param.tele}"><br>
     	密码:<input type="text" name="password" value="${param.password}"><br>
     	性别:
   			男<input type="radio" name="gender" checked="true" value="男">
     		女<input type="radio" name="gender" value="女"><br>
     	宿舍楼:<select name="dormitory" style="width: 97px; ">
     		<option value=""> </option> 
     		<c:forEach items="${applicationScope.arraylist}" var="a">
     			<c:choose>
     				<c:when test="${param.dormitory}==a.name">
     					<option value="${a.name}" selected="selected">${a.name}</option>
     				</c:when>
     				<c:otherwise>
     					<option>${a.name}</option>
					</c:otherwise>
				</c:choose>
     		</c:forEach>
     	</select><br>
     	<input type="hidden" name="status" value="update">	   	
     	<input type="hidden" name="account" value="${param.account}">
     	<input type="submit" value="update" style="color:red">
     	</form>
  </body>
</html>
