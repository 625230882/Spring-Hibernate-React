<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${error}"/>
	<form action="/AntraAssignment_1/login" method="post">
		Username: <input type="text" name="Username"></input>
		Password: <input type="password" name="Password"></input>
		<button type="submit">login</button>
	</form>

</body>
</html>