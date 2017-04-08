<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Welcome: <c:out value="${pageContext.request.remoteUser}"/>  |
	<a href="${pageContext.request.contextPath }/logout"> Logout User </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/stud"> Go To Student Form </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/upload"> File Upload Example </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/rest"> Rest API Example  </a>
	
	<hr/>
	<a href="${pageContext.request.contextPath }/angular"> Angular App  </a>
	
</body>
</html>