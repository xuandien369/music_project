<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Admin</h1>
	<c:forEach var="x" items="${listAll}">
		<h2>Name: ${x.name}</h2>
	</c:forEach>
	  <form action="/j_spring_security_logout" method="post">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout" />
  </form>		
</body>
</html>