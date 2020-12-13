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
	
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('<c:url value="/resources/images/bg-01.jpg"/>');">
		
			<div class="wrap-login100">
				<form action="<c:url value='/reset_password'/>" class="login100-form validate-form" method="post" >
					<input type="hidden" value="${token}" name="token" >
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>
					<span class="login100-form-title p-b-30 p-t-18">
						Forgot Password
					</span>
					<c:if test="${empty message}">
						<span class="login101-form-title p-b-25 p-t-20">
							We will sending a reset password link to your email.
						</span>
					</c:if>
					<c:if test="${not empty message}">
						<span class="login101-form-title p-b-25 p-t-20">
							${message}
						</span>
					</c:if>
					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="password" name="password" placeholder="Enter your new password" required autofocus" id="password">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="password"placeholder="Enter your confirm password" required autofocus" 
						oninput="checkPasswordMatch(this);">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Change Password
						</button>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />			
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
	<script type="text/javascript">
		function checkPasswordMatch(filedConfirmPassword){
			if(filedConfirmPassword.value != $("#password").val()){
				filedConfirmPassword.setCustomValidity("Password do not match");
			}else {
				filedConfirmPassword.setCustomValidity("");
			}
		}
	</script>
</body>
</html>