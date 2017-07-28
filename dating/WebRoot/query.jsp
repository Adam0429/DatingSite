<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
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
  <form action="/dating/myser" method="post">
  <input type="text" name="nameOraccount" value="${sessionScope.nameOraccount}"> <br>
  <input type="submit" name="status" value="queryname">
  <input type="submit" name="status" value="queryaccount">
  </form>
  
    <table border="1">
    	<tr>
    		<td>编号</td>
  			<td>账号</td>
  			<td>昵称</td>
  			<td>性别</td>
  			<td>手机号</td>
  			<td>宿舍</td>
  			<td>更新</td>
  			<td>删除</td>
  		</tr>
   	 	<c:forEach items="${requestScope.Logins}" var="l" varStatus="num">
   			<tr>
   				<td>${num.count}</td>
   				<td>${l.account}</td>
   				<td>${l.name}</td>						<!-- 一些符号不能通过超链接传值,所以选择用jstl -->
   				<td>${l.gender}</td>
   				<td>${l.tele}</td>
   				<td>${l.dormitory}</td>
   				<td><c:url value="/admin/update.jsp" var="update">
   					<c:param name="account" value="${l.account}"></c:param><!-- 这个l.account会自动调用login里的get方法获取值,经试验没有get方法会报错,get方法名不影响运行 -->>
   					<c:param name="name" value="${l.name}"></c:param>
   					<c:param name="tele" value="${l.tele}"></c:param>
   					<c:param name="gender" value="${l.gender}"></c:param>
   					<c:param name="dormitory" value="${l.dormitory}"></c:param>
   					<c:param name="password" value="${l.password}"></c:param>
   					</c:url>
   					<a href="${update}">更新</a>			<!-- href相当于表单,调用doGet -->
   				</td>
   				<td><c:url value="/myser" var="delete">
   					<c:param name="account" value="${l.account}"></c:param>
   					<c:param name="name" value="${l.name}"></c:param>
   					<c:param name="status" value="delete"></c:param>
   					</c:url>
   					<a href="${delete}">删除</a>
   				</td>
   			</tr>
   		</c:forEach>
   	</table>
   	<c:choose>
   		<c:when test="${!empty sessionScope.page}">
   			
   		
   			<a href="/dating/myser?status=splitpage&page=1">首页</a>
   		
		<c:choose>
			<c:when test="${sessionScope.page==1}">
				上一页
			</c:when>
			<c:otherwise>
				<a href="/dating/myser?status=splitpage&page=${sessionScope.page-1}">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${sessionScope.page==sessionScope.totalpage}">
				下一页 
			</c:when>
			<c:otherwise>
				<a href="/dating/myser?status=splitpage&page=${sessionScope.page+1}">下一页 </a>
			</c:otherwise>
		</c:choose>
		<a href="/dating/myser?status=splitpage&page=${sessionScope.totalpage}">尾页 </a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共${sessionScope.totalpage}页
		</c:when>
	</c:choose>
  </body>
</html>
