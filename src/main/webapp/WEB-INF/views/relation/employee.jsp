<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="../header.jsp"/>

	<h2>Employee Information</h2>
	<button class="btn btn-primary" onclick="addEmployee()">
		<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Add Employee
	</button>
	<div id="employeeFormDialog"> </div>

	<hr />
	Employee Details
	<br />
	<table id="employeeTable" border="1" style="border-collapse:collapse">
		<thead>
			<tr>
				<th>ID</th>
				<th></th>
				<th>Name</th>
				<th>Birth Date</th>
				<th>Address</th>
				<th>Phone NO</th>
				<th>Departments</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${employeeList }">
				<tr>
					<td>${row.id }</td>
					<td>
						<button class="btn btn-success" onclick="editEmployee(${row.id})">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit</button>
						<button class="btn btn-danger" onclick="deleteEmployee(${row.id})">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Delete</button> 
						<img alt="" src="${pageContext.request.contextPath }/download?file=${row.avatar}" width="50" height="50" />
					</td>
					<td>${row.firstName }, &nbsp; ${row.lastName }</td>
					<td><fmt:formatDate value="${row.birthDate }" pattern="MM/dd/yyyy" /></td>
					<td>${row.address.city }, ${row.address.country }</td>
					<td><c:forEach var="phoneNo" items="${row.phoneNos}">
							${phoneNo.number }&nbsp;
						</c:forEach>
					</td>
					<td><c:forEach var="department" items="${row.departments }">
							${department.name }&nbsp;
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
	
		function addEmployee(){
			var addEmpUrl = "${pageContext.request.contextPath}/emp/add";
			$.get(addEmpUrl)
				.then(function(empFormDialog){
					$("#employeeFormDialog").html(empFormDialog);
					$("#employeeFormModal").modal('show');
				});
		}
		
		function editEmployee(id){
			var editEmpUrl="${pageContext.request.contextPath}/emp/" + id + "/edit";
			$.get(editEmpUrl)
					.then(function(empFormDialog){
					$("#employeeFormDialog").html(empFormDialog);
					$("#employeeFormModal").modal('show');
				});
		}
		
		function deleteEmployee(id){
			var r = confirm("Are you sure you want to delete this record?");
			if(r == true){
				location.href="${pageContext.request.contextPath}/emp/" + id + "/delete";
			}
		}
		
		$(document).ready(function(){
			$('#employeeTable').DataTable();
		});
		
	</script>


<c:import url="../footer.jsp"/>