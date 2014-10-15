var sortOrderApp = angular.module('sortOrderApp', []);

sortOrderApp.controller('sortOrderCtrl', function ($scope, $http) {

    $scope.randomOrder = function() {
        $scope.order = null;
        $scope.header = null;
        $scope.goCats = true;

        var url = '/rest/order/sort/random/min_box'
        $http.get(url)
            .success(function(data) {
                $scope.order = data;
                $http.get('/header')
                .success(function(data) {
                    $scope.header = data;
                    $scope.goCats = false;
                })
            .error(function (e) {
                alert("error: " + e);
                callback(e);
            });
        });
    }
    $scope.goCats = false;

});