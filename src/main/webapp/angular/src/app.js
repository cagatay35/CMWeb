/**
 * Created by cagatay.gokcel on 3.3.2016.
 */
'use strict';
console.log("angular initialized");
var App = angular.module('CMApp',['ngRoute']).config(function($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl : 'home.jsp',
        controller : 'HomeController',
        controllerAs: 'controller'
    }).when('/user/login', {
        templateUrl : 'login.jsp',
        controller : 'NavigationController',
        controllerAs: 'controller'
    }).otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

})
    .controller('home', function($http) {
        var self = this;
        $http.get('/resource/').success(function(data) {
            self.greeting = data;
        })
    })
    .controller('navigation', function() {});