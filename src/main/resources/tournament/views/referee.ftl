<#-- @ftlvariable name="bettingOpen" type="java.lang.Boolean" -->
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function registerController($scope, $http, $window) {
            $scope.register = function () {
                $http({
                    method: 'POST',
                    url: '/ref/start',
                    data: {name: $scope.name}
                });
            }
            $scope.nextRound = function () {
                $http({
                    method: 'POST',
                    url: '/ref/next_round',
                    data: {name: $scope.name}
                });
            }
        }
    </script>
</head>

<body>

<div ng-app="" ng-controller="registerController">
    <button ng-click="start()">Start tournament</button><br><br>
    <button ng-click="nextRound()">next round</button>
</div>

</body>
</html>