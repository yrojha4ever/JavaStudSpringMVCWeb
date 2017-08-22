<!-- http://getbootstrap.com/javascript/   : Static example -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="studentFormModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
    <form:form action="stud" method="POST" modelAttribute="student" enctype="multipart/form-data">
    
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Student Form</h4>
      </div>
      <div class="modal-body">
      	<div class="form-horizontal">
      	
      	
			<table style="width:100%">
				<tr>
					<td><label>Select a Photo to Upload: <form:input path="file" type="file" class="form-control"/></label></td>
					<td><img id="image" alt="" src="${pageContext.request.contextPath }/download?file=${student.imageName}" width="150" height="100" /></td>
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
				<tr>
					<td><form:label path="rollNo"> Roll NO </form:label></td>
					<td><form:input path="rollNo" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="subject">Subject</form:label></td>
					<td><form:input path="subject" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="collegeName">College Name</form:label></td>
					<td><form:input path="collegeName" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="fee">Fee</form:label></td>
					<td><form:input path="fee" type="number" step="0.01" class="form-control"/></td>
				</tr>
			</table>
			<form:hidden path="id" />
			<form:hidden path="imageName" />
	
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
document.getElementById("file").onchange = function () {
    
	var reader = new FileReader();
    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("image").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};
</script>
