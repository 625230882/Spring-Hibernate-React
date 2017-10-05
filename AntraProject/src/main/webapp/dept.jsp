<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${error }"/>
	<form action="/AntraAssignment_1/dept" method="post">
		Dept: <input type="text" name="DeptName"/><p>
		Email: <input type="text" name="Email"/><br>
		
			<c:if test="${fn:length(Elist) > 0 }">
				<c:forEach items="${Elist }" var="employee">
					<input type="checkbox" name="employees" value="${employee.firstName }${employee.lastName }"  />${employee.firstName } ${employee.lastName }<br>
				</c:forEach>
			</c:if>

		<button type="submit">submit</button>
	</form>
	
	<form action="/AntraAssignment_1/logout" method="get">
	<button type="submit" name="logout">logout</button>
	</form>
	<a href="/AntraAssignment_1/">back</a><br>
	<c:if test="${fn:length(Dlist) > 0 }">
		<c:forEach items="${Dlist }" var="dept">
			Dept: <c:out value="${dept.key.name } ${dept.key.email }"/>
 			<c:forEach items="${dept.value }" var="employee" >
				Name: <c:out value="${employee }"/>
			</c:forEach><br> 
		</c:forEach>
	</c:if>
</body>
</html>