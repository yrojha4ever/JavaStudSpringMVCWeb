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
	File upload example:

	<form action="upload" method="POST" enctype="multipart/form-data">
		File to Upload: <input type="file" name="file"/>
		
		<br/> <br/>
		<input type="submit" value="Upload" /> Press here to upload file!
	</form>

	<br/> <br/> <label style="color:red">${successMsg }</label>
	
	<br/><br/><hr/>
	<c:if test="${fileName ne null }">
		<a href="${pageContext.request.contextPath }/download?file=${fileName}"> Download File </a>
		<img alt="" src="${pageContext.request.contextPath }/download?file=${fileName}" width="800" height="600"/>
	</c:if>
	

</body>
</html>