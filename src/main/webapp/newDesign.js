var newDesign = angular.module('newDesign', ['ngResource']);

newDesign.controller('newDesignCtrl', ['$scope', '$http', '$resource',function($scope, $http, $resource) {
    $scope.size = "John";
    $scope.model = "Doe";
	$scope.buttonName = "Start new design";
	$scope.showForm = false;
	$scope.hideButton = function($button){
	$scope.showForm=true
	$scope.garment="";
	};

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
	$scope.createDesign = function(userFields, garment) {
		var DesignFields = $resource("/avacado/services/design","",{saveData: {method:'POST', isArray: true}});
		garment.designFields = angular.toJson(userFields)
		DesignFields.saveData({}, angular.toJson(garment));
	};
	$scope.count=0;
}]);