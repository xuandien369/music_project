<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-8/css/all.min.css"
	integrity="sha512-bSZEw4uG1xpcaR4ZoNYTsTssbBNq00EMRuS8e2tbE7+gXqVSBbaZIqqvjMDBnde5B4CkMBuaLG6kk7mxdIjF8w=="
	crossorigin="anonymous" />
<link rel="shortcut icon" type="image/png" href="/resources/images/icons/music-note.png"/>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../song/general/header.jsp" %>
	<div class="hrne">
		<hr>
	</div>
	<div class="bodycontent">
		<div class="musicmain">
			<div id="SongnameAndSinger">
				<h2 id="songname">${SongModel.name}</h2>
				<h4 id="singer">
					<i>${SongModel.singer}</i>
				</h4>
			</div>
			<br>
			<audio autoplay src="<c:url value='/MusicStorage/${SongModel.sourceName}'/>"
				controls>
				<!-- <source src="" type="audio/mpeg" id="sourcemain"> -->
			</audio>
			<br>
			<div id="controldetails">
					 <i class="fas fa-stop-circle"
					style="margin-top: 5px; font-size: 28px;"
					id="stop" ></i><i class="fas fa-sync-alt"
					style="margin-top: 5px; font-size: 28px;"
					id="loop"></i>
			</div>
		</div>
	</div>
	<script src="<c:url value='/resources/js/musicdetails.js'/>"></script>
</body>
</html>