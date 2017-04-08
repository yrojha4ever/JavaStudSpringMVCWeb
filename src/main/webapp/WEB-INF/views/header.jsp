<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>
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
	  	
	  		<form class="" action="<c:url value="/logout"/>" method="post">
	  		
			  Welcome: <c:out value="${pageContext.request.remoteUser}"/>  | 
			  
			  <a href="<c:url value="/"/>"> HOME </a>  |
			  <input type="submit" class="btn btn-link" value="Log out"/>
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			
		</div>
	</div>
	<hr/>
	