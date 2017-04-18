<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"/>

	File Upload Example:
	<form action="upload" method="POST" enctype="multipart/form-data">
		File to Upload: <input type="file" name="file" multiple="multiple" accept="image/gif, image/jpeg, image/jpg, image/png, application/pdf"/>
		
		<br/><br/>
		<input type="submit" value="Upload"/> Press here to upload file!
	</form>
	
	<br/> <br/> <label style="color:red">${successMsg }</label>
	
	
	<br/><br/><hr/>
	<div class="row"> 
		<c:forEach var="fileName" items="${fileNames }">
			<div class="col-xs-6 col-md-3">
				<a href="${pageContext.request.contextPath}/download?file=${fileName}" class="thumbnail"> 
				<img src="${pageContext.request.contextPath}/download?file=${fileName}" width="200" height="300"/>
				${fileName} </a>
			</div>
		</c:forEach>
	</div>
	

<c:import url="footer.jsp"/>