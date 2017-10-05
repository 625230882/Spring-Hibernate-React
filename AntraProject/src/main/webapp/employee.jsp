<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is employee
	<form action="/AntraAssignment_1/employee" method="post">
		FirstName: <input type="text" name="FirstName"></input><p>
		LastName: <input type="text" name="LastName"></input><p>
		Age: <input type="text" name="Age"></input><p>
		<button type="submit">add</button>
	</form>
	<form action="/AntraAssignment_1/logout" method="get">
	<button type="submit" name="logout">logout</button>
	</form>
	<a href="/AntraAssignment_1/">back</a>
	<c:if test="${fn:length(Elist) > 0 }">
		<c:forEach items="${Elist }" var="employee">
			FirstName:<c:out value="${employee.firstName }"></c:out>
			LastName:<c:out value="${employee.lastName }"></c:out>
			Age:<c:out value="${employee.age }"></c:out><p>
		</c:forEach>
	</c:if>
</body>
</html>