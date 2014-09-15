<!DOCTYPE html>
<html>

<head>
    <title>Register</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-tower"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://localhost:8080/">Home</a></li>
                <li><a href="http://localhost:8080/brackets">Brackets</a></li>
                <li><a href="http://localhost:8080/bet">Bet</a></li>
                <li><a href="http://localhost:8080/register">Register</a></li>
                <li><a href="http://localhost:8080/contestants">Contestants</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<button type="button" class="btn btn-lg btn-primary" data-animation="am-fade-and-scale" data-placement="center"
        bs-modal="register">
    Click to register.
</button>
</body>

</html>