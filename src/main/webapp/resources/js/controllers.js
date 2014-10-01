var sortOrderApp = angular.module('sortOrderApp', []);

sortOrderApp.controller('sortOrderCtrl', function ($scope, $http) {

    $scope.randomOrder = function() {
        $http.get('/header')
        .success(function(data) {
            $scope.header = data;
            var url = '/rest/order/sort/random'
            $http.get(url)
            .success(function(data) {
                $scope.order = data;
            })
            .error(function (e) {
                alert("error: " + e);
                callback(e);
            });
        });
    };
});