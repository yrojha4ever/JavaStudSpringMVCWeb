<!doctype html>
<html >
<head>
	<script src="${pageContext.request.contextPath }/resources/js/angular.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/app/currencyAngularApp.js"></script>
</head>
<body>
	<h2>Currency </h2>
	
	<div ng-app="currencyApp" ng-controller="CurrencyController">	
		
		<ul>
			<li ng-repeat="(currencyBase, currencyRate) in rates"> 
				<label>  
					<span> {{currencyBase}} : {{currencyRate}} </span>
				</label>				
			</li>			
		</ul>
				
	</div>
</body>
</html>