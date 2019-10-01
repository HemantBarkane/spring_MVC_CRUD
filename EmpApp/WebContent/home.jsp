<%@page import="com.example.dto.User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
	List<User> ulist = (List<User>)request.getAttribute("users");
	
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<table border="2" align="center">
			<% int i=0; for(User u : ulist){ %>
			<tr>
				<td><%=(++i)%></td>
				<td>
				<%=u.getUserName()%>
				</td>
				<td>
				<%=u.getUserPass() %>
				</td>
				<td>
				<a href="delete.htm?userId=<%=u.getUserId()%>" >Delete</a>
				</td>
				<td>
				<a href="select.htm?userId=<%=u.getUserId()%>" >Select</a>
				</td>
			</tr>
			<% } %>
			</table>
			
			<a href="reg.htm">back</a>

</body>
</html>