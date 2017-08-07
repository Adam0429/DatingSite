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
    
    <title>My JSP 'bbs_frame.jsp' starting page</title>
    
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
   <pre><h2>帖子</h2>                                                                                                      <a href="/dating/login/loginframe.jsp">返回<a></pre>
  	<c:forEach items="${applicationScope.bbs_arraylist}" var="b">
		${b.bbs_id}:
		<c:url value="/loginser" var="browse_bbs">
		<c:param name="bbs_id" value="${b.bbs_id}"></c:param>
		<c:param name="status" value="bbs_browse"></c:param>
		</c:url>
		<c:choose>
			<c:when test="${empty b.bbs_title}">
				<a href="${browse_bbs}">不知所云</a> <br>
			</c:when>
			<c:otherwise>
				<a href="${browse_bbs}">${b.bbs_title}</a><br>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty b.login_account}">
				作者:匿名-------发帖时间:${b.bbs_time}<br>
			</c:when>
			<c:otherwise>
				作者:${b.login_account}-------发帖时间:${b.bbs_time}<br>
			</c:otherwise>
		</c:choose>
  	</c:forEach>
  </body>
</html>
