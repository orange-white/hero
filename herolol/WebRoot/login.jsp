<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
	<style type="text/css">
		h1{
			color: #8F3D92;
    		font-size: 40px;
    		font-weight: bolder;
		}
		span{
			color: #8F3D92;
    		font-size: 22px;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#reg").click(function(){
				window.location.href = "regist.jsp";
			});
		});
	</script>
  </head>
  
  <body>
  <br><br><br><br>
    	<form  action="HeroServlet" method="post" style="position: relative;left: 30%;">
    		<h1 align="center" >英&nbsp;雄&nbsp;登&nbsp;录</h1>
    			<input type="hidden" name="method" value="login">
    		<input name="hero" placeholder="请输入英雄名字" class="hero" required />
			<input name="honor" placeholder="请输入英雄称号" class="honor" required />
    		<span>${empty sessionScope.msg ? "" : sessionScope.msg }</span><br>
    		<input name="login" class="btn" type="submit" value="登录" />
    		<input id="reg" name="regist" class="btn" type="button" value="注册" />
    		
    	</form>
  </body>
</html>
