<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newbbs.jsp' starting page</title>
    
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
    请在这里发言<br>
    <form action="/dating/loginser" method="post"> 
    	标题:<br><input type="text" name="bbs_title"><br><br>内容:<br>
    	<textarea name="bbs_content" style="height: 127px; width: 503px"></textarea>
    	<input type="checkbox" name="noname">匿名发言<br>
    	<input type="submit" value="提交">
    	<input type="hidden" name="status" value="newbbs">
    </form>
  </body>
</html>
