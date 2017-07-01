<!-- http://getbootstrap.com/javascript/   : Static example -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="employeeFormModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
    <form:form action="emp" method="POST" modelAttribute="employee" enctype="multipart/form-data">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Employee Form</h4>
      </div>
      <div class="modal-body">
      	<div class="form-horizontal">
      	
      	
			<table style="width:100%">
				<tr>
					<td><label>Select a Photo to Upload: <form:input path="avatarFile" type="file" class="form-control"/></label></td>
					<td><img id="avatarImage" alt="" src="${pageContext.request.contextPath }/download?file=${employee.avatar}" width="150" height="100" /></td>
				</tr>
				<tr>
					<td><form:label path="birthDate"> Birth Date </form:label></td>
					<td><form:input path="birthDate" type="date" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="firstName"> First Name </form:label></td>
					<td><form:input path="firstName" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="lastName"> Last Name </form:label></td>
					<td><form:input path="lastName" class="form-control"/></td>
				</tr>
				<!-- Address: One TO One -->
				<tr>
					<td><form:label path="address.city">Address(One to One: )City</form:label></td>
					<td><form:input path="address.city" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="address.state">State</form:label></td>
					<td><form:input path="address.state" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="address.zip">Zip</form:label></td>
					<td><form:input path="address.zip" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="address.country">Country</form:label></td>
					<td><form:input path="address.country" class="form-control"/>
					<form:hidden path="address.id"/></td>
				</tr>
				<!-- Phone No. One To Many -->
				<tr>
					<td><form:label path="phoneNos[0].number">Phone No: (One to Many)Phone Number 1</form:label></td>
					<td><form:input path="phoneNos[0].number" class="form-control"/>
						<form:hidden path="phoneNos[0].id"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="phoneNos[1].number">Phone Number 2</form:label></td>
					<td><form:input path="phoneNos[1].number" class="form-control"/>
						<form:hidden path="phoneNos[1].id"/>
					</td>
				</tr>
				<!-- Department: Many To Many -->
				<tr>
					<td><label>Departments(Many to Many)<label></td>
					<td> 
						<form:select id="departments" path="departments" class="multiselect required" multiple="multiple" style="height:80px">
		                    <option value=""> -- Please choose --</option>
		                    <c:forEach var="dept" items="${departments}">
		                    	<c:set var="setSelected" value="false"></c:set>
		                    	<c:forEach var="empDept" items="${employee.departments}">
		                    		<c:if test="${empDept.id eq dept.id }">
		                    			<c:set var="setSelected" value="true"></c:set>
		                    		</c:if>
		                    	</c:forEach>
		                    	<c:choose>
			                    		<c:when test="${setSelected eq true }">
					                    	<option value="${dept.id }" selected="selected">${dept.name }</option>
			                    		</c:when>
			                    		<c:otherwise>
			                    			<option value="${dept.id }">${dept.name }</option>
			                    		</c:otherwise>
		                    		</c:choose>
		                    </c:forEach>
		                </form:select>
					</td>
				</tr>
			</table>
			<form:hidden path="id" />
			<form:hidden path="avatar" />
	
		</div>
	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      
      </form:form>
      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
document.getElementById("avatarFile").onchange = function () {
    
	var reader = new FileReader();
    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("avatarImage").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};
</script>
