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
  <%
  	ArrayList<Login> arrayList=(ArrayList)request.getAttribute("Logins");
  	if(arrayList!=null){//判断是否为空,否则会有空指针错误
   		%>
   		<%out.print("name:"+arrayList.get(0).getName());%><br>
   		<%out.print("account:"+arrayList.get(0).getAccount());%><br>
   		<%out.print("telephone:"+arrayList.get(0).getTele());
    }
    else
    	out.print("no result");
    %>
  </body>
</html>
