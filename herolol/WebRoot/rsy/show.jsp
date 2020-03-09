<%@page import="com.rsy.entity.Hero"%>
<%@page import="com.rsy.dao.impl.HeroDaoImpl"%>
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

<title>查看页面</title>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#back").click(function() {
			window.history.back();
		});
	});
</script>
<style type="text/css">
		body{
			background-size:cover;
			font-family:"楷体";
			font-size: 30px;
			font-weight:bolder;
			color:white;
		}		
</style>
</head>

<body>
		<%
			Hero h = (Hero)request.getAttribute("h");
		%>
	<table id="tb1" >
			<caption style="font-size: 60px;color:#764146;font-family:Comic Sans MS">H        E        R        O</caption>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			<tr>
				<td>英雄名字</td>
				<td>${h.hero}</td>
			</tr>
			
    	
    	<button id="out" name="out" class="btn" type="button" value="返回" />
    </table>
</body>
</html>
