<#assign title="Login">
<#assign ngAppName="app">
<#assign ngController="login as vm">

<#assign scripts>
<script src="/app/register.js"></script>
</#assign>

<#assign content>
Name: <input type="text" ng-model="vm.name"><br>
Password: <input type="password" ng-model="vm.password"><br>
<input type="button" ng-click="vm.postInfo()">Login</input><br><br>

Don't have an account? <button ng-click="gotoRegister">Register</button>
</#assign>

<#include "template.ftl" parse=true>