<%@page import="com.rsy.entity.Hero"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" href="css/style3.css" media="screen" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>

</head>

<body >
	
		<%
			Hero h = (Hero)request.getAttribute("h");
		%>
		<form id="f" action="HeroServlet?method=doUpdate" method="post" enctype="multipart/form-data" style="position: relative;left: 10%;">
			<input type="hidden" name="id" value="${h.id}"  />
			<input name="hero" value="${h.hero}" class="hero" required />
			<input name="honor" value="${h.honor}" class="hero" required />
			<input type="file" name="head" class="hero" value="${h.head}">
			<input name="local1" value="${h.local1}" class="hero" />
			<input name="local2" value="${h.local2}" class="hero"  />
			<input name="local3" value="${h.local3}" class="hero"  />
			<textarea rows="6" cols="60" name="story" class="message" >${h.story}</textarea>
    	<input name="ret" class="btn" type="reset" value="重置" />
    	<input name="conv" class="btn" type="submit" value="确定" />
</form>
</body>
</html>
