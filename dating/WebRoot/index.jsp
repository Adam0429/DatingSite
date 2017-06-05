<!-- jsp的声明 --,这个语句是用来拼装当前网页的相对路径的>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  	
     <form action="/dating/myser" method="post">
     中蓝公寓通知群----一些重要的通知都会发放在这里,请同学们多多查看--来自校领导<br>
     	注册<br>
     	昵称:<input type="text" name="name"><br>
     	性别:女<input type="radio" name="girl"><br>
     	手机号:<input type="text" name="tele"><br>
     	账号:<input type="text" name="account"> <!-- sname is the parameter's name , provide servlet to ues --> &nbsp;<br>
     	密码:<input type="text" name="password">
     	                      <br/><input type="submit" value="submit" style="color:red"><!-- type=text是明文显示，password是密文显示,还有等等.....相当于java的api吧 -->
     
     	<input type="hidden" name="status" value="insert">
     </form>
     	<form action="/dating/query.jsp">
     		<input type="submit" value="query">
         </form>
  </body>
  
</html>
