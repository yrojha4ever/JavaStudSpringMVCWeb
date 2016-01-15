<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/logout">Logout User</a> |
	<a href="${pageContext.request.contextPath}/stud">Go To Student Form</a> |
	<a href="${pageContext.request.contextPath}/rest" > Rest API Call</a> <hr/>
	
	File Upload Example: 
	<hr/>
	<form method="POST" action="upload" enctype="multipart/form-data" style="color:blue;border: 1px solid">
        File to upload: <input type="file" name="file">
        <br /> <br/>
        <input type="submit" value="Upload"/> Press here to upload the file!
    </form>
	
	<br/><br/>
	<label style="color:red">${successMsg}</label>
	
</body>
</html>