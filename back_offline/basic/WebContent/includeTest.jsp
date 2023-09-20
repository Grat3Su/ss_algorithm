<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String str = "PPPP"; %>
<%-- 
<jsp:include page="nav.jsp" flash="true"/>
<%@ 	include page="nav.jsp" %>

--%>
<%@ include file="nav.jsp" %>
	<h2>Body</h2>
	<div>내용</div>
	<%=str %>
</body>
</html>