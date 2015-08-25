var newDesign = angular.module('newDesign', ['ngResource']);

/*newDesign.factory('Fields',  ['$resource', function($resource) {
	return $resource('http://localhost:8080/avacado/services/design/fields',null, {isArray:true})
}]);*/

newDesign.controller('newDesignCtrl', ['$scope', '$http', '$resource',function($scope, $http, $resource) {
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
			$scope.designFields = resp;
		},
		error: function(e){
			//window.alert("error" + e);
		}
	});
	$scope.createDesign = function(userFields) {
		var DesignFields = $resource("/avacado/services/design","",{saveData: {method:'POST', isArray: true}});
		DesignFields.saveData({}, angular.toJson(userFields));
		//var designFields1 = new DesignFields(JSON.stringify(userFields));

		/*$.ajax({
			type: "POST",
			url: "/avacado/services/design",
			dataType: 'json',
			data: JSON.stringify(userFields),
			contentType:"application/json",
			processData: false
		});*/

		/*$.POST("/avacado/services/design",fields).
			done(function(resp){
				Window.alert("success" + resp);
			}).
			fail(function(e){
				window.alert("error" + e);
			});*/
	};
	$scope.count=0;
}]);




/*
var Field = $resource('/services/design/fields');
var fields = User.get(function() {
	isArray:true;
	fields.save();
	$scope.fields = fields;
});*/
