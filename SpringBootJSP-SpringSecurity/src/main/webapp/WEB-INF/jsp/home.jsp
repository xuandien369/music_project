<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-8/css/all.min.css"
	integrity="sha512-bSZEw4uG1xpcaR4ZoNYTsTssbBNq00EMRuS8e2tbE7+gXqVSBbaZIqqvjMDBnde5B4CkMBuaLG6kk7mxdIjF8w=="
	crossorigin="anonymous" />
<title>Music Box</title>
</head>
<body>
	<div class="header">
		<ul class="ulheader">
			<a href="#"><li class="logoheader">Music Box</li></a>
			<div class="search">
				<form>
					<input type="text" name="keyworld" id="search" placeholder="">
					<button type="submit">Search</button>
				</form>
			</div>
			<div class="featureheader">
				<a href="/login"><li>Sign in</li></a> <a href="#"><li>Sign up</li></a> <a
					href="#"><li>Favorite List</li></a>
			</div>
		</ul>
	</div>

	<div class="hrne">
		<hr>
	</div>
	<div class="bodycontent">
		<div class="musicmain">
			<a href="<c:url value='/user'/>">USER</a> <a
				href="<c:url value='/admin'/>">ADMIN</a>
				<br><br>
			<div id="SongnameAndSinger">
				<h2 id="songname">Nàng Thơ</h2>
				<h4 id="singer">
					<i>Hoàng Dũng</i>
				</h4>
			</div>
			<br>
			<audio autoplay src="<c:url value='/resources/music/Nang-Tho.mp3'/>"
				controls>
				<!-- <source src="" type="audio/mpeg" id="sourcemain"> -->
			</audio>
			<br>
			<div id="control">
				<i class="fas fa-step-backward"
					style="margin-top: 5px;  font-size: 28px;"
					id="prev" ></i> <i class="fas fa-stop-circle"
					style="margin-top: 5px; font-size: 28px;"
					id="stop" ></i> <i class="fas fa-step-forward"
					style="margin-top: 5px;  font-size: 28px;"
					id="next"></i> <i class="fas fa-sync-alt"
					style="margin-top: 5px;  font-size: 28px;"
					id="loop"></i>
			</div>
		</div>
		<div class="listSongFE"></div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/music.js'/>"></script>
</body>
</html>