<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="passwordMeterApp">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Avaliador de Segurança de Senha">
    <meta name="keywords" content="Avaliador de Segurança, Password Meter, Senha">
    <meta name="author" content="Evandro Panaro Cavichioli">

    <title>{{'HEADER_TITLE' | translate}}</title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/custom.css" var="customCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${customCss}" rel="stylesheet"/>
</head>
<body>

<div class="container" ng-controller="passwordController">
    <div class="row">
        <div class="col-sm-12" ng-controller="languageController">
            <a href="#" ng-click="changeLanguage('pt_BR')">{{'BUTTON_LANG_PT' | translate}}</a>
            |
            <a href="#" ng-click="changeLanguage('en_US')">{{'BUTTON_LANG_EN' | translate}}</a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <h3>
                <small>{{'TITLE' | translate}}</small>
            </h3>
            <div class="well">
                <div class="row">
                    <div class="col-xs-6">
                        <input type="password" class="form-control" id="password"
                               placeholder="{{'INPUT_PASSWORD' | translate}}" ng-change="onChangePassword()"
                               ng-model="password">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <h3>
                            <span class="label label-default">{{score}}%</span>
                            <span class="label {{labelCss}}">{{complexity | translate}}</span>
                        </h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryJs"/>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/js/angular.min.js" var="angularJs"/>
<spring:url value="/resources/js/angular-resource.min.js" var="angularResourcesJs"/>
<spring:url value="/resources/js/angular-translate.min.js" var="angularTranslateJs"/>
<spring:url value="/resources/js/app.js" var="appJs"/>

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${angularJs}"></script>
<script src="${angularResourcesJs}"></script>
<script src="${angularTranslateJs}"></script>
<script src="${appJs}"></script>

</body>
</html>