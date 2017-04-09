<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/jquery.dataTables.css">

<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
<script	src="${pageContext.request.contextPath }/resources/js/jquery.dataTables.js"></script>

</head>
<body>

	<div class="container-fluid">
	  	<div class="row">
	  	
	  		Welcome: <%=session.getAttribute("activeUser")%> | <a href="${pageContext.request.contextPath }/logout"> Logout User </a>
			
		</div>
	</div>
	<hr/>
	