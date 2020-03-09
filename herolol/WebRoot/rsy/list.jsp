<%@page import="com.rsy.entity.Hero"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>HERO</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/style1.css" media="screen" type="text/css" />

   <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/modernizr.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>

<body >
	<c:set var="image_path" value="http://localhost:8080/hero"></c:set>
	<form id="Form1" action="HeroServlet" method="post">
		<input type="hidden" name="method" value="list" />
		 <input type="hidden" id="pageNo" name="pageNo" value="${pageNo}" /> 
		 <input type="hidden" id="pageSize" name="pageSize" value="${pageSize}" />
		<input type="hidden" id="pageTotal" name="pageTotal" value="${pageTotal}" />
		
		<div style="float: left;margin-left: 15%">
		<table id="tb1" >
			<caption style="font-size: 60px;color:#764146;font-family:Comic Sans MS">H        E        R        O</caption>
		
		<tr id="thead">
				<th>头像</th>
				<th>英雄</th>
				<th>称号</th>
				<th>定位</th>
				<th>黎明就在眼前</th>
		</tr>
		<tbody id="tt">
				<c:forEach var="h" items="${heros}">
					<tr>
						<td><img src="${image_path}${h.head }" width="64px" height="64px"></td>
						<td>${h.hero}</td>
						<td>${h.honor}</td>
						<td>${h.local1}&nbsp;${h.local2}&nbsp;${h.local3}</td>
						<td>
						<input id="del" name="del" class="btn" type="button" value="删除" 
						 onclick="new function(){window.location.href = 'HeroServlet?method=delete&id=${h.id}';}" />
						<input id="upd" name="upd" class="btn" type="button" value="编辑" 
						 onclick="new function(){window.location.href = 'HeroServlet?method=toUpdate&id=${h.id}';}" /> 
						<input id="vie" name="vie" class="btn" type="button" value="查看" 
						 onclick="new function(){window.location.href = 'HeroServlet?method=toShow&id=${h.id}';}"/>
						<input id="play" name="play" class="btn" type="button" value="PLAY"  /> </td>
					</tr>
				</c:forEach>
		
			</tbody>
	</table>
	</div>
		<div style="float: left;margin-left: 20%;margin-top:10px;">
		<input id="out" name="out" class="btn" type="button" value="退出"  />
			<input type="button" name="pa" class="btn" value="${pageNo}/${pageTotal}">	
			<input type="button" id="go"name="go" class="btn" value="GO">
			<input id="no" name="no" placeholder="${pageNo}" class="honor"/>
			<input name="query" class="btn" type="submit" value="查询" />
			<input name="honor" placeholder="请输入英雄称号" class="honor" />
			<input type="button" id="last"name="last" class="btn" value="尾页">
			<input type="button" id="next"name="next" class="btn" value="下一页">
			<input type="button" id="pre"name="pre" class="btn" value="上一页">
			<input type="button" id="first" name="first" class="btn" value="首页">	
				
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			
			$("#out").click(function(){
				window.location.href = "HeroServlet?method=logout";
			});
			
			$("#first").click(function() {
				$("#pageNo").val(1);
				$("#Form1").submit();
			});

			$("#pre").click(function() {
				var nowPageNo = $("#pageNo").val();
				$("#pageNo").val(parseInt(nowPageNo) - 1);
				$("#Form1").submit();
			});

			$("#next").click(function() {
				var nowPageNo = $("#pageNo").val();
				$("#pageNo").val(parseInt(nowPageNo) + 1);
				$("#Form1").submit();
			});

			$("#last").click(function() {
				var pageTotal = $("#pageTotal").val();
				$("#pageNo").val(pageTotal);
				$("#Form1").submit();
			});

			$("#go").click(function() {
				var nowPageNo = $("#no").val();
				$("#pageNo").val(nowPageNo);
				$("#Form1").submit();
			});

		});
	</script>
	
</body>
</html>
