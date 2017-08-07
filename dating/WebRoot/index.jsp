<!-- jsp的声明 --,这个语句是用来拼装当前网页的相对路径的>
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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%@page import="java.util.ArrayList"%>
</head>
  <title>中蓝公寓官网</title>
  <body><script type="text/javascript">alert("中蓝公寓官网");
  
 	

  </script>
  <%

   %>
  	
     <form action="/dating/myser" method="post">
     <h3>中蓝公寓通知网 </h3>
     
     	<p align='left'>一些重要的通知都会发放在这里,请同学们多多查看--来自校领导  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;
     		<a href="/dating/adminser?status=adminauto"> 后台</a><br>
     		</p>
     <hr width="80%" align="left">
    	 <pre>
注册                 <a href="/dating/loginser?status=loginauto"> 登录</a>               <a href="query.jsp">-----查询-----</a> <br>
账号:<input type="text" name="account"> <!-- sname is the parameter's name , provide servlet to ues --> &nbsp;<br>
密码:<input type="text" name="password"><br>
昵称:<input type="text" name="name"><br>
性别:男<input type="radio" name="gender" value="男"> 女<input type="radio" name="gender" value="女"><br> 	
手机号:<input type="text" name="tele"><br>
宿舍楼:<select name="dormitory">
     		<option></option>
     		<c:forEach items="${applicationScope.arraylist}" var="a">
     		<option value="${a.name}">${a.name}</option>
     		</c:forEach>
     		</select><br>
上传照片:<input type="file" name="pic">
     		</pre>
  		<input type="submit" value="submit" style="color:red" onmouseover="f(this)" onmouseout="f1(this)" >
  		<script type="text/javascript">
  			function f(sub){
  				sub.style.color="white";
  			}
  			function f1(sub){
  				sub.style.color="red";
  			}
  			</script>
     	${RegisterError}
     	<input type="hidden" name="status" value="insert">
	</form>
	 <%!    int count=0;        %>    <%    count++;    out.println("已有"+count+"人访问!");    %>
  </body>
  
</html>
