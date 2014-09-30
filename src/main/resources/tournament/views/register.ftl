<#-- @ftlvariable name="registrationOpen" type="java.lang.Boolean" -->
<#assign title="Register">
<#assign ngAppName="app">
<#assign ngController="register as vm">

<#assign scripts>
<script src="/app/register.js"></script>
</#assign>

<#assign content>
    <#if registrationOpen>
    Name: <input type="text" ng-model="vm.name"><br>
    Password: <input type="password" ng-model="vm.password"><br><br>

    <input type="checkbox" ng-model="vm.competing"> Competing?<br>
    Competition name: <input type="text" ng-model="vm.contestantName" ng-show="vm.competing" ng-disable="vm.competing"><br><br>

    <button ng-click="vm.postInfo()">Register</button>
    <#else>
    Registration is closed.
    </#if>
</#assign>

<#include "template.ftl" parse=true>
