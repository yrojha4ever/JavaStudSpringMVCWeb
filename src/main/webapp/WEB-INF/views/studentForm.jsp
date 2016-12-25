<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap-theme.css">
<link  rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/jquery.dataTables.css">

<script src="${pageContext.request.contextPath }/resources/js/jquery.js" ></script>
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js" ></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.dataTables.js" ></script>

</head>
<body>

<nav class="navbar navbar-inverse">
  ...
</nav>
	
	Welcome: <%=session.getAttribute("activeUser") %>  |
	<a href="${pageContext.request.contextPath }/logout"> Logout User </a>
	
	<hr> <h2>Student Information</h2>
	<form:form method="POST" modelAttribute="student">
		<table>
			<tr>
				<td>  <form:label path="firstName"> First Name </form:label> </td>
				<td> <form:input path="firstName"/>	</td>
			</tr>
			<tr>
				<td>  <form:label path="lastName"> Last Name </form:label> </td>
				<td> <form:input path="lastName"/>	</td>
			</tr>
			<tr>
				<td>  <form:label path="rollNo"> Roll NO </form:label> </td>
				<td> <form:input path="rollNo"/>	</td>
			</tr>
			<tr>
				<td><form:label path="subject">Subject</form:label></td>
				<td><form:input path="subject" /></td>
			</tr>
			<tr>
				<td><form:label path="collegeName">College Name</form:label></td>
				<td><form:input path="collegeName" /></td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit" class="btn btn-info" value="Save"/> </td>
			</tr>
		</table>
		<form:hidden path="id"/>
	</form:form>
	
	<hr/> Student Details <br/>
	<table id="studTable" border="1" style="border-collapse: collapse">
		<thead>
			<tr>
				<th> ID </th>
				<th> </th>
				<th> Name </th>
				<th> Roll No </th>
				<th> Subject </th>
				<th> College Name </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="row" items="${studentList }">
				<tr>
					<td> ${row.id } </td>
					<td> 
						<button class="btn btn-success" onclick="editStud(${row.id})" > Edit  </button>
						<button class="btn btn-danger" onclick="deleteStud(${row.id})"> Delete </button>
					</td>
					<td> ${row.firstName }, &nbsp; ${row.lastName } </td>
					<td> ${row.rollNo } </td>
					<td> ${row.subject }</td>
					<td> ${row.collegeName }</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	
	<script type="text/javascript">
		function editStud(id){
			location.href="${pageContext.request.contextPath}/stud/" + id + "/edit";
		}
		function deleteStud(id){
			var r = confirm("Are you sure you want to delete this record?");
			if(r == true){
				location.href="${pageContext.request.contextPath}/stud/" + id + "/delete";
			}
		}
		
		$(document).ready(function(){
			$('#studTable').DataTable();
		});
		
	</script>
	










</body>
</html>