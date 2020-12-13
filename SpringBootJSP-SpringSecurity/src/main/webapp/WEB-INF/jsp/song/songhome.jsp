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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-8/css/all.min.css"
	integrity="sha512-bSZEw4uG1xpcaR4ZoNYTsTssbBNq00EMRuS8e2tbE7+gXqVSBbaZIqqvjMDBnde5B4CkMBuaLG6kk7mxdIjF8w=="
	crossorigin="anonymous" />
<link rel="shortcut icon" type="image/png" href="/resources/images/icons/music-note.png"/>
<title>Song</title>
<style>
.pagination {
  display: block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}
.ahihi h2{
	display: inline-block;
}
</style>
</head>
<body>
	<%@ include file="../song/general/header.jsp" %>
	<div class="hrne">
		<hr>
	</div>
	<div class="bodycontent">
		<div class="ListSongAll">
			<c:forEach var="item" items="${ListSong	}">
				<a href="/song/${item.id}">${item.name}-${item.singer}</a>&nbsp;<i
					onclick="ChooseFavorite(${item.id})" class="fab fa-gratipay" style="color:pink;"></i>
				<br>
				<br>
				<div id="${item.id}" class="hidden">
					<c:if test="${not empty idne}">
						<select id="select-${item.id}">
							<option value="" selected disabled="disabled">--Select
								Favorite Song--</option>
							<c:forEach var="i" items="${currentUserFMList}">
								<option value="${i.id}">${i.name}</option>
							</c:forEach>
						</select>
						<button onclick="addFavoriteSong(${item.id})">Add</button>
					</c:if>
				</div>
				<br>
			</c:forEach>
		</div>
		<div class="pagination">
						<a href='<c:url value="/?page=${currentPage-2<0?0:currentPage-2}"/>'>&laquo;</a> 
				<c:forEach var="item" begin="1" end="${totalPage}">
						<a href='<c:url value="/?page=${item-1}"/>' ${item==currentPage?'class="active"':''}>${item}</a>
				</c:forEach>
				<a href='<c:url value="/?page=${currentPage==totalPage?totalPage-1:currentPage}"/>'>&raquo;</a>
		</div>
	</div>
		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/favoritesongadd.js'/>"></script>
</body>
</html>