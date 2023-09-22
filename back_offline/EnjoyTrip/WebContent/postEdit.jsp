<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<h1>Post</h1>
	<form method="post" action="main">
		<fieldset>
		<legend style = "text-align = "center"">POST</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="post">
		<input type="text" style = "width: 90%; height: 100%; " id="title" name="title" placeholder = "Title"><br>
		
		<br>
		<textarea style = "width: 100%; height: 300px; " id="desc" placeholder = "Input..." name="desc"></textarea><br>
		<input type="submit" value="등록">
		<input type="reset" value="리셋">
		</fieldset>
	</form>
</body>
</html>