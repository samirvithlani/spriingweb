<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="insertuser" modelAttribute="userBean">  
UNAME<form:input path="uName" />
UEMAIL<form:input path="uEmail" />
UEMAIL<form:input path="uPassword" type="password" />
UEMAIL<form:input path="uAge" />
		<input type="submit" value="REFISTER">


	</form:form>
</body>
</html>