<%@page import="java.awt.print.Printable"%>
<%@page import="info.Login"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <input type="text" name="name"> <br>
  <input type="submit" value="查询">
  <input type="hidden" name="status" value="query">
  
  </form>
  <table  border="1">
  	<tr>
  		<td>name</td>
  		<td>account</td>
  		<td>telephone</td>
  		<td>删除</td>
  		<td>更新</td>
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
   		<td><a href="query.jsp">删除</td>
  		<td><a href="query.jsp">更新</td>
   	</tr>
   	<% 
    	}
   	}
    else
    	out.print("no result");
    %>
     
    </table>
  </body>
</html>
