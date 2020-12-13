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
<title>Song</title>
</head>
<body>
	<%@ include file="../song/general/header.jsp" %>
	<div class="hrne">
		<hr>
	</div>
	<div class="bodycontent">
		<div class="musicmain">
			<div id="SongnameAndSinger">
				<h2 id="songname"></h2>
				<h4 id="singer">
				</h4>
			</div>
			<br>
			<audio autoplay src=""
				controls>
				<!-- <source src="" type="audio/mpeg" id="sourcemain"> -->
			</audio>
			<br>
			<div id="control">
				<i class="fas fa-step-backward"
					style="margin-top: 5px;  font-size: 22px;"
					id="prev" ></i> <i class="fas fa-stop-circle"
					style="margin-top: 5px; font-size: 22px;"
					id="stop" ></i> <i class="fas fa-step-forward"
					style="margin-top: 5px;  font-size: 22px;"
					id="next"></i> <i class="fas fa-retweet"
					style="margin-top: 5px;  font-size: 25px;"
					id="loop"></i>
			</div>
		</div>
		<input type="hidden" value="${FMid}" id="FMidne"/>
		<div class="listSongFE"></div>
		</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/xuandien369.js'/>"></script>
</body>
</html>