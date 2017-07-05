<%@page import="java.awt.print.Printable"%>
<%@page import="info.Login"%>
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
  <input type="text" name="nameOraccount"> <br>
  <input type="submit" name="status" value="queryname">
  <input type="submit" name="status" value="queryaccount">
  </form>
  
  <table  border="1">
  	<tr>
  		<td>name</td>
  		<td>account</td>
  		<td>telephone</td>
  		<td>更新</td>
  		<td>删除</td>
  	</tr>
  
  
  <%
  	ArrayList<Login> arrayList=(ArrayList)request.getAttribute("Logins");
  	if(arrayList!=null){//判断是否为空,否则会有空指针错误
  	for(int i=0;i<arrayList.size();i++){
   	%>
   	<tr>
   		<td><%out.print(arrayList.get(i).getName());%></td>
   		<td><%out.print(arrayList.get(i).getAccount());%></td>
   		<td><%out.print(arrayList.get(i).getTele());%></td>
  		<td><a href="/dating/update.jsp?account=<%=arrayList.get(i).getAccount()%>&name=<%=arrayList.get(i).getName() %>">更新</a></td>
  		<td><a href="/dating/myser?account=<%=arrayList.get(i).getAccount()%>&status=delete">删除</a></td>
  		<!-- href=<百分号=path%> path作为变量名，<百分号= %>是取变量名。 -->
   	</tr>
    <% 
    	}
   	}
    else
    	//out.println("no result");
    %>
     </table>
    =====================jstl=======================
    <table border="1">
    	<tr>
    		<td>index</td>
  			<td>name</td>
  			<td>account</td>
  			<td>telephone</td>
  			<td>更新</td>
  			<td>删除</td>
  		</tr>
   	 	<c:forEach items="${requestScope.Logins}" var="l" varStatus="num">
   			<tr>
   				<td>${num.count}</td>
   				<td>${l.name}</td>						<!-- 一些符号不能通过超链接传值,所以选择用jstl -->
   				<td>${l.account}</td>
   				<td>${l.tele}</td>
   				<td><c:url value="/update.jsp" var="update">
   					<c:param name="account" value="${l.account}"></c:param>
   					<c:param name="name" value="${l.name}"></c:param>
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
  </body>
</html>
