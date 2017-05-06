<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="header.jsp"/>

	<h2>Student Information</h2>
	<button class="btn btn-primary" onclick="addStud()">
		<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add Student
	</button>
	<div id="studentFormDialog"> </div>

	<hr />
	Student Details
	<br />
	<table id="studTable" border="1" style="border-collapse:collapse">
		<thead>
			<tr>
				<th>ID</th>
				<th></th>
				<th>Name</th>
				<th>Birth Date</th>
				<th>Roll No</th>
				<th>Subject</th>
				<th>College Name</th>
				<th>Fee</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${studentList }">
				<tr>
					<td>${row.id }</td>
					<td>
						<button class="btn btn-success" onclick="editStud(${row.id})">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit</button>
						<button class="btn btn-danger" onclick="deleteStud(${row.id})">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Delete</button> 
						<img alt="" src="${pageContext.request.contextPath }/download?file=${row.imageName}" width="50" height="50" />
					</td>
					<td>${row.firstName }, &nbsp; ${row.lastName }</td>
					<td><fmt:formatDate value="${row.birthDate }" pattern="MM/dd/yyyy" /></td>
					<td>${row.rollNo }</td>
					<td>${row.subject }</td>
					<td>${row.collegeName }</td>
					<td>${row.fee }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<script type="text/javascript">
	
		function addStud(){
			var addStudUrl = "${pageContext.request.contextPath}/stud/add";
			$.get(addStudUrl)
				.then(function(studFormDialog){
					$("#studentFormDialog").html(studFormDialog);
					$("#studnetFormModal").modal('show');
				});
		}
		
		function editStud(id){
			var editStudUrl="${pageContext.request.contextPath}/stud/" + id + "/edit";
			$.get(editStudUrl)
					.then(function(studFormDialog){
					$("#studentFormDialog").html(studFormDialog);
					$("#studnetFormModal").modal('show');
				});
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


<c:import url="footer.jsp"/>