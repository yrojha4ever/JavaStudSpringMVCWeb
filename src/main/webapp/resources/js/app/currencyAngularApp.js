angular.module('currencyApp',[])
.controller('CurrencyController', function($scope, $http){
	$scope.rates = [];
	$http.get('http://api.fixer.io/latest?base=USD').then(function(result) {
       $scope.rates = result.data.rates;
    });			
});