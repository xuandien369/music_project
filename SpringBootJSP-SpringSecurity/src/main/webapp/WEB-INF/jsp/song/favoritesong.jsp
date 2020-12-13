<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<form action="<c:url value='/favoritesong/add'/>" method="post">
	<ul id="growing-search-freebie">
    <li>
      <div class="growing-search">
        <div class="input">
          <input type="text" name="fmname" placeholder="Name.."/>
        </div><!-- Space hack --><div class="submit">
          <button type="submit" name="go_search">
            <i class="fas fa-plus-circle" style="color:#d24dff;"></i>
          </button>
        </div>
      </div>
    </li>
  </ul>
</form>
	<br><br>
	<div class="ListSongAll">
			<c:forEach var="item" items="${favoritesListSong}">
				<a href="<c:url value='/favoritesong/details/${item.id}'/>">${item.name}</a>&nbsp;<a onclick="deleteFM(${item.id},${idne})"><i class="fas fa-trash" style="color:#b478ed;"></i></a><br><br>
			</c:forEach>
		</div>
	</div>
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/favoritesongdelete.js'/>"></script>
</body>
</html>