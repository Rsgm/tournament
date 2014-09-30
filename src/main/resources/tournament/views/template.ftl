<#-- @ftlvariable name="title" type="java.lang.String" -->
<#-- @ftlvariable name="content" type="java.lang.String" -->
<#-- @ftlvariable name="ngAppName" type="java.lang.String" -->
<#-- @ftlvariable name="ngController" type="java.lang.String" -->
<#-- @ftlvariable name="scripts" type="java.lang.String" -->

<!DOCTYPE html>
<html>

<head>
    <title>${title?html}</title>

    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <script src="/app/app.module.js"></script>
    ${scripts}
</head>

<body role="document">

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
                <li <#if title = "Home">class="active"</#if>><a href="http://localhost:8080/">Home</a></li>
                <li <#if title = "Brackets">class="active"</#if>><a href="http://localhost:8080/brackets">Brackets</a></li>
                <li <#if title = "Betting">class="active"</#if>><a href="http://localhost:8080/bet">Bet</a></li>
                <li <#if title = "Register">class="active"</#if>><a href="http://localhost:8080/register">Register</a></li>
                <li <#if title = "Contestants">class="active"</#if>><a href="http://localhost:8080/contestants">Contestants</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<#if ngAppName??>
<div class="container" role="main" id="ng-app" ng-app="${ngAppName}" ng-controller="${ngController}">
<#else>
<div class="container" role="main">
</#if>
${content}
</div>

</body>
</html>