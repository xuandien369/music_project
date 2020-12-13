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
	<h1>Contact Page</h1>
	<form action="<c:url value='/contact'/>" method="post" enctype="multipart/form-data">
		Fullname: <input type="text" name="fullname"style="width: 250px;"/><br><br>
		Email's recipient: <input type="email" name="emailne" style="width: 250px;"/><br><br>
		Content: <textarea rows="5" name="content" style="width: 280px;"></textarea><br><br>
		Attachment: <input type="file" name="attachment" style="width: 250px;"/><br><br>
		<button type="submit">Send</button>
	</form>
</body>
</html>