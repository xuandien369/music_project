<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html >
<head>
	<title>Login Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value='/resources/images/icons/favicon.ico'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/fonts/iconic/css/material-design-iconic-font.min.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/animate/animate.css'/>"/>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/css-hamburgers/hamburgers.min.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/animsition/css/animsition.min.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/select2/select2.min.css'/>"/>
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/vendor/daterangepicker/daterangepicker.css'/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/util.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-8/css/all.min.css"
	integrity="sha512-bSZEw4uG1xpcaR4ZoNYTsTssbBNq00EMRuS8e2tbE7+gXqVSBbaZIqqvjMDBnde5B4CkMBuaLG6kk7mxdIjF8w=="
	crossorigin="anonymous" />
	
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('<c:url value="/resources/images/bg-01.jpg"/>');">
			<div class="wrap-login100">
				<form action="/JSSLogin" class="login100-form validate-form" method="post" >
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>
					<span class="login100-form-title p-b-30 p-t-18">
						Log in
					</span>
					<c:if test="${not empty message}">
						<span class="login100-form-title p-b-25 p-t-20">
								${message}
						</span>
					</c:if>

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>
					<span class="social">
						<a href='<c:url value="/oauth2/authorization/github"/>' id="githubicon"><i class="fab fa-github"></i></a>
						<a href='<c:url value="/oauth2/authorization/facebook"/>' id="facebookicon"><i class="fab fa-facebook"></i></a>
						<a href='<c:url value="/oauth2/authorization/google"/>' id="googleicon"><i class="fab fa-google"></i></a>
					</span>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="text-center p-t-65">
						<a class="txt1" href="<c:url value='/forgot_password'/>">
							Forgot Password?
						</a>
					</div>				
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/jquery/jquery-3.2.1.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/animsition/js/animsition.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/bootstrap/js/popper.js'/>"></script>
	<script src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/select2/select2.min.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/daterangepicker/moment.min.js'/>"></script>
	<script src="<c:url value='/resources/vendor/daterangepicker/daterangepicker.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/vendor/countdowntime/countdowntime.js'/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>