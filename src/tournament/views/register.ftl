<!DOCTYPE html>
<html>

<head>

<title>Register</title>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
<script>
     function registerController($scope,$http) {
         $scope.register = function() {
             $http({
                 method: 'POST',
                 url: '/register?name=' + $scope.name,
                 headers: {'Content-Type': 'application/x-www-form-urlencoded'}
             }).success(function (data) {
                window.location.replace("/contestant?id=" + data.id);
             });
         };
     };
</script>
</head>

<body>

<div ng-app="" ng-controller="registerController">
name: <input type="text" ng-model="name"><br>
<button ng-click="register()">Register</button><br>
</div>

</body>
</html>