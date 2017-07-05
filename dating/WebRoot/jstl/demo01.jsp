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
    
    <title>My JSP 'demo01.jsp' starting page</title>
    
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
  <% request.setAttribute("name", "sname");
  	 request.setAttribute("age" ,  "sage");
  	 %>

   <a href="http://www.baidu.com"><c:out value="${requestScope.name} "></c:out></a>
   <c:if test="${5>2}">
   	5
   </c:if>
   <c:choose>
   		<c:when test="${3>2}">
   			3大
   		</c:when>
   		<c:otherwise>
   			2大
   		</c:otherwise>
  </c:choose>
  <c:forEach begin="1" end="5" var="i" step="2">
  	${i}
  </c:forEach>
  <%
    		ArrayList<String> temp=new ArrayList<String>();
    		temp.add("aaa");
    		temp.add("bbb");
    		request.setAttribute("temp",temp);
    		request.setAttribute("abc",null);
    	 %>
    	 <c:forEach items="${requestScope.temp}" var="s">
    	 	${s}
    	 </c:forEach>
  </body>
</html>
