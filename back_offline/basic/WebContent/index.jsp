<%@page import="com.sun.org.apache.bcel.internal.generic.GETSTATIC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.StudentDto, dto.SidoDto, java.util.List"%>
<%
	List<StudentDto> studentList = (List<StudentDto>) request.getAttribute("studentList");
	List<SidoDto> sidoList = (List<SidoDto>) request.getAttribute("sidoList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<%
		for (StudentDto dto : studentList) {
	%>

	<h2><%=dto.getStudentId()%> <%=dto.getStudentNM()%></h2>
	<%
		}
	%>
<hr>
	<select>
		<%
			for (SidoDto dto : sidoList) {
		%>

		<option value="<%=dto.getSidoCode()%>"><%= dto.getSidoNM() %></option>

		<%
					}
				%>
	</select>
</body>
</html>