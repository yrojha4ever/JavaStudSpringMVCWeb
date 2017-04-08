<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

	<section class="loginform cf">
		<form action="login" method="post">
			<ul>
				<li>
					<c:if test="${error ne null}">
						<div>
							<h3 class="error"> Sorry User/Password invalid! Please re-login. </h3>
						</div>
					</c:if>
					<c:if test="${logout ne null}">
						<div>
							<h3 class="error"> Successfully Logged out. </h3>
						</div>
					</c:if>
				</li>
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
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	 </section>


</body>
</html>