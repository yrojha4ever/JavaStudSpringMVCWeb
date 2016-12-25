<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rest Example</title>

	<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
	
</head>
<body>

	<h3>Rest Call Example:</h3>
	
	<button onclick="showStudJsonData()"> Show All Students</button>
	<p id="studJSON"> </p>
	<hr/>
	
	<p id="currency"> </p>


	<script type="text/javascript">
	
		function showStudJsonData(){
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "api/rest/students"
			}).then(function(data){
				$("#studJSON").html( JSON.stringify( data ) );
			});
		}
		
		//http://api.fixer.io/latest?base=USD
		$(document).ready(function(){
			
			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "http://api.fixer.io/latest?base=USD"
			}).then(function(result){
				$.each(result.rates, function(key, value){
					$("#currency").append('<label>'+ key + " : " + value + '</label> <br/>');
				});
			});
			
		});
		
	</script>

</body>
</html>