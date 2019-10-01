<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<spring:form action="reg.htm" commandName="user" method="Post" >
		UserName <spring:input path="userName"  /><br><br>
		password <spring:password path="userPass" /><br><br>
				<input type="submit" value="Register"><br><br>
	</spring:form>
	<a href="prep_login_form.htm">Back</a>
</body>
</html>