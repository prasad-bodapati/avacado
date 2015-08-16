var newDesign = angular.module('newDesign', []);

newDesign.controller('newDesignCtrl', function($scope) {
    $scope.size = "John";
    $scope.model = "Doe";
	$scope.buttonName = "Start new design";
	$scope.showForm = false;
	$scope.hideButton = function($button){
	$scope.showForm=true
	};
});
