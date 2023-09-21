<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#book-list {
	border-collapse: collapse;
	width: 100%;
}

#book-list td, #book-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>도서 목록</h1>
	<table id="book-list">
		
		<tbody>
		<tr>
				<td>ISBN</td><td>${book.isbn}</td>
		</tr>
		<tr>
				<td>제목</td><td>${book.title}</td>
		</tr>
		<tr>
				<td>저자</td><td>${book.author}</td>
		</tr>
		<tr>
				<td>가격</td><td>${book.price}</td>
		</tr>
		<tr>
				<td>설명</td><td>${book.desc}</td>
		</tr>
		</tbody>
	</table>
	
	<li><a href="./regist.jsp">도서 등록</a>
	<li><a href="./main?action=list">도서 목록</a> 
	<li><a href="./main?action=update">도서 수정</a> 
	<li><a href="./main?action=list">도서 삭제</a> 
</body>
</html>