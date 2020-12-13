<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/fake.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-8/css/all.min.css"
	integrity="sha512-bSZEw4uG1xpcaR4ZoNYTsTssbBNq00EMRuS8e2tbE7+gXqVSBbaZIqqvjMDBnde5B4CkMBuaLG6kk7mxdIjF8w=="
	crossorigin="anonymous" />
<link rel="shortcut icon" type="image/png" href="/resources/images/icons/music-note.png"/>
<title>Song</title>
</head>
<body>
	<%@ include file="../song/general/header.jsp" %>
	<div class="hrne">
		<hr>
	</div>
	<div class="bodycontent">
	<form action='<c:url value="/song/addSong"/>' enctype="multipart/form-data" method="post">
		<label>Nhập tên bài hát: </label>		
		<input type="text" name="name">
		<br><br>
		<label>Nhập tên ca sĩ: </label>		
		<input type="text" name="singer">
		<br><br>
		<label>Nhập file: </label>		
		<input type="file" name="fileMusic">
		<br><br>
		<select name="categorySongID"> 
			<option value="" selected disabled="disabled">--Select
								Favorite Song--</option>
			<c:forEach var="i" items="${ListCategory}">
					<option value="${i.id}">${i.name}</option>
			</c:forEach>
		</select>
		<br><br>
		<button type="submit">Đăng</button>
	</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
</body>
</html>