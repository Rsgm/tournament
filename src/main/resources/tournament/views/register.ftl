<!DOCTYPE html>
<html>

<head>
    <title>Register</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function registerController($scope, $http, $window) {
            $scope.register = function () {
                $http({
                    method: 'POST',
                    url: '/register',
                    data: {name: $scope.name}
                }).success(function (data) {
                    $window.location.replace("/contestant?id=" + data.id);
                });
            }
        }
    </script>
</head>

<body>

<div ng-app="" ng-controller="registerController">
    name: <input type="text" ng-model="name"><br>
    <button ng-click="register()">Register</button>
    <br>
</div>

</body>
</html>