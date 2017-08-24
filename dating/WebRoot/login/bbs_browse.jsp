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
    
    <title>My JSP 'bbs_browse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>

  <body>	
 
		<input type="button" value="返回" id="back"><br>
		帖子编号:${requestScope.bbs.bbs_id}<br><br>
		标题: 	${requestScope.bbs.bbs_title}<br><br>
		内容：${requestScope.bbs.bbs_content}<br><br>
		作者：${requestScope.bbs.login_account}<br><br>
		<input type="button" value="回复" id="replybutton">
		<input type="hidden" id="replycontent">
		<script type="text/javascript">
			var button=document.getElementById("replybutton");
			var content=document.getElementById("replycontent");
			var back=document.getElementById("back");
			back.onclick=function(){
				history.back();
			}
			button.onclick=function(){
				var reply=prompt("请输入要回复的内容");
				content.value=reply;
			}
		</script>
  </body>
</html>
