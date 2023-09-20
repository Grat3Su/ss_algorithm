<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String str = "QQQQ";
%>
<jsp:include page="nav.jsp" flush="true"/>
	<h2>Body2</h2>
	<%= str %>
</body>
</html>