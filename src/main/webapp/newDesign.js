var newDesign = angular.module('newDesign', ['ngResource']);

/*newDesign.factory('Fields',  ['$resource', function($resource) {
	return $resource('http://localhost:8080/avacado/services/design/fields',null, {isArray:true})
}]);*/

newDesign.controller('newDesignCtrl', ['$scope', '$http', function($scope, $http) {
    $scope.size = "John";
    $scope.model = "Doe";
	$scope.buttonName = "Start new design";
	$scope.showForm = false;
	$scope.hideButton = function($button){
	$scope.showForm=true
	};
	/*$http.get('http://localhost:8080/avacado/services/design/fields').
		then('$scope',function($scope, response) {
			window.alert(response.data);
		}, function(response) {
			window.alert(response)
		});*/

	$.ajax({
		type: "GET",
		url: "/avacado/services/design/fields",
		dataType: "json",
		crossDomain: true,
		success: function(resp){
			$scope.fields = resp;
		},
		error: function(e){
			//window.alert("error" + e);
		}
	});

}]);




/*
var Field = $resource('/services/design/fields');
var fields = User.get(function() {
	isArray:true;
	fields.save();
	$scope.fields = fields;
});*/
