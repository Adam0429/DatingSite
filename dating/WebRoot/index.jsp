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
	
	-->
 
  <%@page import="java.util.ArrayList"%>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>
  <title>中蓝公寓官网</title>
  <body>
  
 	

  <script src="layui/layui.js"></script>
  <%

   %>
  
    

     
     </div>
    <ul class="layui-nav layui-nav layui-bg-green" pc>
    <li class="layui-nav-item layui-this">
      	 北京工业大学中蓝公寓官网 
      </li>
      <li class="layui-nav-item layui-this">
        <a href="/dating/loginser?status=loginauto"> 登录</a>
      </li>
      <li class="layui-nav-item ">
        <a href="javascript:;" onclick="f4()">注册<span class="layui-badge-dot"></span></a>
      </li> 
      
      <li class="layui-nav-item" pc>
        <a href="/dating/query.jsp"> 查询</a>
      </li>
      
      <li class="layui-nav-item" pc onclick="f3()">
        <a href="javascript:;">反馈</a>
      
      </li>
      <li class="layui-nav-item" mobile>
        <a href="javascript:;" onclick="f5()">分享</a>
      </li>
    </ul>
  </div>
</div>
<br>
    	<div id="tip">
     		<a href="http://www.bjut.edu.cn/"><img alt="img" src="img/1.jpg" style="width: 961px; height: 318px; "></a>
     	</div>
     	<br>
     	<div style="width:100%;height:50px;white-space:nowrap;">
     	<div style="display: inline-block;width:45%;"><p align='left'>一些重要的通知都会发放在这里,请同学们多多查看  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;</div>
     	<div style="display: inline-block;width:25%;"><a href="/dating/adminser?status=adminauto">	<button class="layui-btn layui-btn-small layui-btn-radius layui-btn-danger">后台登录</button></a></div>
     	<div div class="layui-anim layui-anim-up layui-anim-loop"style="display: inline-block;width:25%;" ><i class="layui-icon" style="font-size: 30px; color: #1E9FFF;" onclick="f5()">&#xe641</i></div>
 
</div>
     		     <br>
     		</p>
     		 
     <hr width="80%" align="left">
    	<ul class="layui-timeline">
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">6月17日</h3>
      <p>
        myeclipse,tomcat一切就绪...
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">7月1日</h3>
      <p>本人怀揣梦想,开始第一页的制作...</p>
      <ul>
      </ul>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <h3 class="layui-timeline-title">8月20日</h3>
      <p>
      	 有了自己的域名,第一次有了自己维护的网站...
      </p>
    </div>
  </li>
  <li class="layui-timeline-item">
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
    <div class="layui-timeline-content layui-text">
      <div class="layui-timeline-title">过去</div>
    </div>
  </li>
</ul>
    	 <br>
<form action="/dating/myser" method="post">

账号:<input type="text" name="account" id="account" value="不能为空!" id="reg"> <!-- sname is the parameter's name , provide servlet to ues --> &nbsp;<br>
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
上传照片:<input type="file" name="pic" id="reg">
     		</pre><br>
  		<input type="submit" value="提交注册" class="layui-btn layui-btn-radius" onmouseover="f(this)" onmouseout="f1(this)" ">
  		<input type="hidden" name="status" value="insert">
  		${RegisterError}<br>
  	</form>
  			
  		<form action="/dating/myser" id="formsug" method="post">
  		 <button type="button" class="layui-btn layui-btn-mini layui-btn-radius " onclick="f3()">意见反馈</button>
  		 <input type="hidden" name="suggest" id="suggest">			
  		 <input type="hidden" name="status" value="suggest">
  		 </form>
  	<script type="text/javascript">
  		var pic=1;
  		setInterval(changimg,1000);
  		var a=document.getElementById("account");
  		var p=document.getElementById("password");
  		var tip=document.getElementById("tip");
  		var dor=document.getElementById("dormitory");
  		var male=document.getElementById("male");
  		var female=document.getElementById("female");
  		var pa=document.getElementById("pa");
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
  				sub.style.color="red";
  			}
  			function f1(sub){
  				sub.style.color="white";
  			}
  			function f3(){
  				var sug=prompt();
  				if(sug==''){
  					alert('不能为空')
  				}
  				else{
  					document.getElementById("suggest").value=sug;
  					document.getElementById("formsug").submit();
  				}    
  			}
  			function f4(){
  				location.hash="#reg";
  			}
  			function f5(){
  				alert('复制本站地址:http://localhost:8080/dating 发给朋友');
  			}
  		</script>
  		
     	


	 <%!    int count=0;        %>    <%    count++;    out.println("已有"+count+"人访问!");    %>
  </body>
  
</html>
