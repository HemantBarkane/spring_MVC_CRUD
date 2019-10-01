<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spr:form action="update.htm" commandName="user" method="post" >
		<spr:hidden path="userId" />
		User Name:<spr:input path="userName" /><br>
		Password:<spr:password path="userPass" /><br>
		<input type="submit" value="Update"><br>
	</spr:form>
	
</body>
</html>