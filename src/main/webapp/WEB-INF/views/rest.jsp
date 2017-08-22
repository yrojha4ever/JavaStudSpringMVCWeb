<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

	<h3>Rest Call Example:</h3>
	
	<button onclick="showStudJsonData()"> Show All Students</button>
	<button onclick="showSpringRestCurrencyData()"> Get Currency Rate</button>
	<p id="studJSON"> </p>
	<hr/>
	
	<div id="currency" style="width:400px" class="panel panel-success"> 
		<!-- loading -->
		<div class="panel-heading">Today's Currency Rate</div>
		<table id="currencyTable" class="stripe" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>Base USD(<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>) </th>
	                <th>Rate</th>
	            </tr>
	        </thead>
        </table>
	 </div>


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
			var currencyTbl = $('#currencyTable').DataTable({
				scrollY : 210,
				scrollCollapse : true,
				paging: false,
				searching : false,
				"bInfo" : false <!-- hide showing 1 to N Entries -->
			});
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "http://api.fixer.io/latest?base=USD"
			}).then(function(result){
				$.each(result.rates, function(key, value){
					currencyTbl.row.add([key, value]).draw(false); <!-- draw(paging); default:paging true -->
				});
			});
			
		});
		
	</script>

<c:import url="footer.jsp"/>