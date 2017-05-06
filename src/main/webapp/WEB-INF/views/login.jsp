<!-- http://www.hongkiat.com/blog/html5-loginpage/ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<style type="text/css">
.error{
	color:red
}
</style>

</head>
<body>

	<h3 class="error"> ${loginError} </h3>

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