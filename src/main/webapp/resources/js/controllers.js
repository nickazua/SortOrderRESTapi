var sortOrderApp = angular.module('sortOrderApp', []);

sortOrderApp.controller('sortOrderCtrl', function ($scope, $http) {

    $scope.randomOrder = function() {
        $http.get('/header')
        .success(function(data) {
            $scope.header = data;

            $http.post('/rest/order/random')
            .success(function(data) {
                $http.post('/rest/order/sort', data)
                .success(function(data) {
                    $scope.order = data;
                })
            })
        });
    };
});