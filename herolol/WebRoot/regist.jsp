<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="css/style2.css" media="screen" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#back").click(function(){
				window.history.back();
			});
		});
	</script>
  </head>
  
  <body>
  <form id="f" action="HeroServlet?method=regist" method="post" enctype="multipart/form-data" style="position: relative;left: 10%;">
			<input name="hero" placeholder="英雄名字" class="hero" required />
			<input name="honor" placeholder="英雄称号" class="hero" required />
			<input type="file" name="head" class="hero" >
			<input name="local1" placeholder="定位1" class="hero"  />
			<input name="local2" placeholder="定位2" class="hero"  />
			<input name="local3" placeholder="定位3" class="hero"  />
			<textarea rows="6" cols="60" name="story" placeholder="背景故事" class="message" ></textarea>
    	<input id="back" name="back" class="btn" type="button" value="返回" />
    	<input name="regist" class="btn" type="submit" value="注册" />
</form>
  </body>
</html>
