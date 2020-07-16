<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${basePath }user/index.do">首页</a>
<h3>选择文件</h3>
<form enctype="multipart/form-data" method="post" action="${basePath }doupload.do">
	<input type="file" name="mulFile">
	<button type="submit">上传</button>
</form>
</body>
</html>