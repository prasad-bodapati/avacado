var app = angular.module('app',['newDesign','defineFields','ngRoute']);

app.config(['$routeProvider', '$locationProvider',
  function($routeProvider, $locationProvider) {
    $routeProvider
      .when('/defineFields', {
        templateUrl: 'defineFields.html',
        controller: 'DefineFieldsCtrl',
        controllerAs: 'fields'
      })
	  .when('/newDesign', {
        templateUrl: 'newDesign.html',
        controller: 'newDesignCtrl',
        controllerAs: 'fields'
      });

    //locationProvider.html5Mode(true);
}]);
app.controller('MainCtrl', ['$route', '$routeParams', '$location',
  function($route, $routeParams, $location) {
    this.$route = $route;
    this.$location = $location;
    this.$routeParams = $routeParams;
}]);


app.goTo = function ( path ) {
	$location.path( path );
};