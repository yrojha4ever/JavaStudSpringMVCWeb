<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	
	<section class="loginform cf">
		<form action="profile" method="post" model="user" accept-charset="utf-8">
			<ul>
				<li>
					<label for="username">Username</label>
					<input type="text" name="username" placeholder="username" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login">
				</li>
			</ul>
		</form>
	 </section>
	
	
</body>
</html>