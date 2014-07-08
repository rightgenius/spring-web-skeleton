<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<ul>
		<c:forEach items="${users}" var="user">
			<li>${user.name}</li>
		</c:forEach>
	</ul>
</body>
</html>