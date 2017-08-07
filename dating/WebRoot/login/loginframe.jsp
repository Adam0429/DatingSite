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
    
    <title>My JSP 'loginframe.jsp' starting page</title>
    
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
     欢迎！${sessionScope.loginaccount}
      <script type="text/javascript">
   	 	var date=new Date().getDate();
 		 switch(date){
 		 case 0:
 		 	document.write(",今天是星期日");
 		 	break;
  		case 1:
  			document.write(",今天是星期一");
  			break;
  		case 2:
  			document.write(",今天是星期二");
  			break;
  		case 3:
  			document.write(",今天是星期三");
  			break;
  		case 4:
  			document.write(",今天是星期四");
  			break;
  		case 5:
  			document.write(",今天是星期五");
  			break;
  		case 6:
  			document.write(",今天是星期六");
  			break;
  			
  }</script>
     <br>
     <a href="/dating/login/newbbs.jsp">发言</a>..........
     <a href="/dating/loginser?status=bbs_frame">查看帖子</a>
  </body>
</html>
