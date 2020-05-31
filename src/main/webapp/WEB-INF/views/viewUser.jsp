<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("loggedinuser");
		if (userBean != null) {
	%>
	USER LIST

	<table background="PINK" border="3">
		<tr>
			<th>USER ID</th>
			<th>USER NAME</th>
			<th>USER EMAIL</th>
			<th>USER PASSWORD</th>
			<th>USER AGE</th>
		</tr>
		<c:forEach items="${users }" var="users">
			<tr>
				<td>${users.uName }</td>
				<td>${users.uName }</td>
				<td>${users.uEmail }</td>
				<td>${users.uPassword }</td>
				<td>${users.uAge}</td>



			</tr>
		</c:forEach>
	</table>

	<%
		} else {

			response.sendRedirect("login");
		}
	%>

</body>
</html>