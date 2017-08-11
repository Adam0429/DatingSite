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
  <body>
  
 	

  </script>
  <%

   %>
     <form action="/dating/myser" method="post">
     
     <h3>北京工业大学中蓝公寓官网 </h3>
    	<div id="tip">
     		<a href="http://www.bjut.edu.cn/"><img alt="img" src="img/1.jpg" style="width: 961px; height: 318px; "></a>
     	</div>
     	<p align='left'>一些重要的通知都会发放在这里,请同学们多多查看--来自校领导  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;
     		<a href="/dating/adminser?status=adminauto"> 后台</a><br>
     		</p>
     <hr width="80%" align="left">
    	 <pre>
注册                 <a href="/dating/loginser?status=loginauto"> 登录</a>               <a href="query.jsp">-----查询-----</a> <br>
账号:<input type="text" name="account" id="account" value="不能为空!"> <!-- sname is the parameter's name , provide servlet to ues --> &nbsp;<br>
密码:<input type="password" name="password" id="password" value="不能为空!"><br>
昵称:<input type="text" name="name"><br>
性别:男<input type="radio" name="gender" value="男" id="male"> 女<input type="radio" name="gender" value="女" id="female"><br> 	
手机号:<input type="text" name="tele"><br>
宿舍楼:<select name="dormitory" id="dormitory">
     		<option></option>
     		<c:forEach items="${applicationScope.arraylist}" var="a">
     		<option value="${a.name}">${a.name}</option>
     		</c:forEach>
     		</select><br>
上传照片:<input type="file" name="pic">
     		</pre>
  		<input type="submit" value="submit" style="color:red" onmouseover="f(this)" onmouseout="f1(this)" onclick="alert('注册成功')">
  		<input type="submit" value="测试" onclick=f3()>
  	<script type="text/javascript">
  		var pic=1;
  		setInterval(changimg,1000);
  		var a=document.getElementById("account");
  		var p=document.getElementById("password");
  		var tip=document.getElementById("tip");
  		var dor=document.getElementById("dormitory");
  		var male=document.getElementById("male");
  		var female=document.getElementById("female");
  		a.onfocus=function(){
  			if(a.value="不能为空!")
  				a.value="";
  		}
  		a.onblur=function(){
  			if(a.value=="")
  				a.value="不能为空!";
  		}
  		p.onfocus=function(){
  			if(p.value="不能为空!")
  				p.value="";
  		}
  		p.onblur=function(){
  			if(p.value=="")
  				p.value="不能为空!";
  		}
  		dor.onchange=function(){
  			var d=this.value;
  			if(d=="蓝悦园"){
  				male.checked=true;
  				female.checked=false;
  			}
  			else{
  				female.checked=true;
  				male.checked=false;
  			}
  		}
  		function changimg(){
  			if(pic%2==1){
  				tip.innerHTML="<a href='http://www.bjut.edu.cn/'><img alt='img' src='img/2.png' style='width: 961px; height: 318px; '></a>";
  				pic++;

  			}
  			else{
  				tip.innerHTML="<a href='http://www.bjut.edu.cn/'><img alt='img' src='img/1.jpg' style='width: 961px; height: 318px; '></a>";
  				pic++;

  			}
  		}
  		
  		
  		
  	
  			function f(sub){
  				sub.style.color="white";
  			}
  			function f1(sub){
  				sub.style.color="red";
  			}
  			function f3(){
  				alert(document.getElementById("password").value);
  			}
  		</script>
     	${RegisterError}
     	<input type="hidden" name="status" value="insert">

	</form>
	 <%!    int count=0;        %>    <%    count++;    out.println("已有"+count+"人访问!");    %>
  </body>
  
</html>
