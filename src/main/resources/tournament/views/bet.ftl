<#-- @ftlvariable name="bettingOpen" type="java.lang.Boolean" -->
<#assign title="Betting">
<#assign ngAppName="app">
<#assign ngController="bet">

<#assign scripts>
<script src="/app/bet.js"></script>
</#assign>

<#assign content>
    <#--<#if bettingOpen>-->
    <#--{{ table }}-->


    <table>
        <tr ng-repeat="x in contestants">
            <td>{{ x.name }}</td>
            <td>{{ x.id }}</td>
            <td>{{ x.difficulty }}</td>
            <td><>
        </tr>
    </table>
    <#--<#else>-->
    <#--Betting is not open yet.-->
    <#--</#if>-->
</#assign>

<#include "template.ftl" parse=true>