<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Welcome: <%=session.getAttribute("activeUser") %>  |
	<a href="${pageContext.request.contextPath }/logout"> Logout User </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/stud"> Go To Student Form </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/upload"> File Upload Example </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/rest"> Rest API Example  </a>
	
	<hr/>
	
</body>
</html>