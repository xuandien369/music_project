<div class="header">
		<ul class="ulheader">
			<a href="<c:url value='/'/>"><li class="logoheader">Music
					Box</li></a>
			<div class="search">
				<form>
					<input type="text" name="keyworld" id="search" placeholder="">
					<button type="submit">Search</button>
				</form>
			</div>
			<sec:authorize access="!isAuthenticated()">
				<div class="featureheader">
					<a href="<c:url value='/login'/>"><li>Log in</li></a> <a href="#"><li>Sign
							up</li></a><a href="<c:url value='/contact'/>"><li>Contact Test</li></a>
				</div>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="featureheader" style="margin-left: 340px;">
					<div class="hello">
						<h4>
							Xin chào,
						<sec:authentication property="principal.username" />
						</h4>
						&nbsp;
					</div>
					<a href="/j_spring_security_logout">Thoát</a> &nbsp;&nbsp;
						<a href="<c:url value='/favoritesong/${idne}'/>"><h4>
								<li>Favorite List</li>
							</h4></a>
						<br><br>
					<sec:authorize access="hasAnyAuthority('ADMIN')">
						<a href="<c:url value='/manage'/>"><h4>
								<li>Manage Page</li>
						</h4></a>			
					</sec:authorize>
				</div>
	</div>
	</sec:authorize>
	</ul>
	</div>