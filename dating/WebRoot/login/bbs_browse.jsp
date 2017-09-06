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
	<link rel="stylesheet" href="layui/css/layui.css">
	
  </head>

  <body>	
  		<script src="layui/layui.js"></script>
 		<form action="/dating/loginser" method="post" id="formreply"> 
		<br>
		帖子编号:${sessionScope.bbs.bbs_id}<br><br>
		标题: 	${sessionScope.bbs.bbs_title}<br><br>
		内容：${sessionScope.bbs.bbs_content}<br><br>
		作者：${sessionScope.bbs.login_account}<br><br>
		回复：<br>
		<c:forEach items="${sessionScope.reply_arraylist}" var="r" varStatus="num">
			${num.count}:
			${r.reply_content}<br>
			发言者:${r.login_account}<br>
			发布时间:${r.reply_time}<br><br>
		</c:forEach>
		<input type="button" value="回复" class="layui-btn layui-btn-small layui-btn-radius layui-btn-warm" id="replybutton">
		<input type="hidden" id="replycontent" name="replycontent">
		<input type="hidden" name="status" value="reply"><input type="button" value="返回" class="layui-btn layui-btn-small layui-btn-radius layui-btn-danger" id="back">
		</form>
		<script type="text/javascript">
			var button=document.getElementById("replybutton");
			var content=document.getElementById("replycontent");
			var back=document.getElementById("back");
			back.onclick=function(){
				history.back();
			}
			button.onclick=function(){
				content.value=prompt("请输入要回复的内容");
				document.getElementById("formreply").submit();    
			}
		</script>
  </body>
</html>
