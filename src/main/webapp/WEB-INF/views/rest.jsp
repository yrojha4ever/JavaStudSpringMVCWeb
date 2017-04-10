<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

	<h3>Rest Call Example:</h3>
	
	<button onclick="showStudJsonData()"> Show All Students</button>
	<button onclick="showSpringRestCurrencyData()"> Get Currency Rate</button>
	<p id="studJSON"> </p>
	<hr/>
	
	<p id="currency"> loading... </p>


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
		
		function showSpringRestCurrencyData(){
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "api/rest/currency"
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
				$('#currency').html("");
				$.each(result.rates, function(key, value){
					$("#currency").append('<label>'+ key + " : " + value + '</label> <br/>');
				});
			});
			
		});
		
	</script>

<c:import url="footer.jsp"/>