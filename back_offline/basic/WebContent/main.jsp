
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.UserDto, dto.SidoDto, java.util.List"%>
<%
	List<SidoDto> sidoList = (List<SidoDto>) request.getAttribute("sidoList");
%>
    
    <%
    //DB Access
    //뿌려줄 데이터를 추출
    // 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한글</title>
</head>

<%
	UserDto userDto = (UserDto)session.getAttribute("userDto");
	if(userDto != null) {
%>
 <h1>반갑습니다. <%=userDto.getUserName() %>!!!</h1>
<a href="/Loginout?job=logout"> 로그아웃</a>
<%
	} else{
%>
<h1>로그인 하세요</h1>
<a href="/login/login.jsp"> 로그인 페이지</a>
<%
	}
%>
<body>
<h1>main.jsp</h1>

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