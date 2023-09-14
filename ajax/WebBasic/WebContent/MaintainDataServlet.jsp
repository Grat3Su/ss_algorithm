<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	String attr1 = (String)request.getAttribute("attr1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Maintaindata.jsp</h1>
	<h2>arr1 : <%= attr1 %></h2>
</body>
</html>