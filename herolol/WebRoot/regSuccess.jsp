<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>跳转页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style4.css" media="screen" type="text/css" />

   <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
	
</head>

<body>
	<br><br><br><br><br>
	<center>
		<h1>注册成功！ <span id="sp" class="sp">5</span>秒之后跳转到登录页面</h1>
		<a class="sp" href="login.jsp">前往登陆</a>
	</center>
</body>
<script type="text/javascript">
	
	var i=4;
	function step(){
		$("#sp").html(i);
		i--;
		if(i<0){
			window.location.href="login.jsp";
		}
	}
	
	setInterval(step, 1000);
	
</script>
</html>
