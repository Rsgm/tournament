<html>
<head>
    <title>contestant</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function contestantController($scope, $http, $window) {
            $http({
                method: 'POST',
                url: '/contestants'
            }).success(function (data) {
                $scope.contestants = data;
            });
        }
    </script>
</head>

<body>
<div ng-app="" ng-controller="contestantController">
    <table>
        <tr ng-repeat="x in contestants">
            <td>{{ x.name }}</td>
            <td>{{ x.id }}</td>
            <td>{{ x.difficulty }}</td>
        </tr>
    </table>
</div>
</body>

</html>