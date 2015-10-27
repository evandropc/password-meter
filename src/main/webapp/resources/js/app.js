var app = angular.module("passwordMeterApp", ['ngResource', 'pascalprecht.translate']);

app.controller("passwordController", function ($scope, $translate, PasswordCheck) {

    var complexitys = [
        {tipo:"VERY_SHORT", labelCss:"label-danger"},
        {tipo:"VERY_WEAK", labelCss:"label-danger"},
        {tipo:"WEAK", labelCss:"label-warning"},
        {tipo:"GOOD", labelCss:"label-info"},
        {tipo:"STRONG", labelCss:"label-success"},
        {tipo:"VERY_STRONG", labelCss:"label-primary"}];

    $scope.onChangePassword = function () {
        if($scope.password != ''){
            PasswordCheck.get({ password: $scope.password }, function(data) {
                $scope.score = data.score;
                showComplexity(data.complexity);
            });
        }else{
            init();
        }
    };

    function showComplexity(tipo) {
        for (var t in complexitys) {
            var value = complexitys[t];
            if(value.tipo === tipo){
                $scope.labelCss = value.labelCss;
                $scope.complexity = value.tipo;
                break;
            }
        }
    }

    function init() {
        $scope.score = 0;
        showComplexity("VERY_SHORT");
    }

    init();

});

app.controller("languageController", function ($scope, $translate) {

    $scope.changeLanguage = function (key) {
        $translate.use(key);
    };

});


app.factory("PasswordCheck", function($resource) {
    return $resource("rest/password-check/:password");
});

app.config(function ($translateProvider) {
    $translateProvider.translations('en_US', {
        HEADER_TITLE: 'Password Meter',
        TITLE: 'PASSWORD SECURITY',
        BUTTON_LANG_EN: 'English',
        BUTTON_LANG_PT: 'Portuguese',
        INPUT_PASSWORD: 'Password',
        VERY_SHORT: 'Very short',
        VERY_WEAK: 'Very Weak',
        WEAK: 'Weak',
        GOOD: 'Good',
        STRONG: 'Strong',
        VERY_STRONG: 'Very Strong'
    });
    $translateProvider.translations('pt_BR', {
        HEADER_TITLE: 'Medidor de Senha',
        TITLE: 'AVALIADOR DE SEGURAN\u00C7A DE SENHA',
        BUTTON_LANG_EN: 'Ingl\u00EAs',
        BUTTON_LANG_PT: 'Portugu\u00EAs',
        INPUT_PASSWORD: 'Senha',
        VERY_SHORT: 'Muito Curta',
        VERY_WEAK: 'Muito Fraca',
        WEAK: 'Fraca',
        GOOD: 'Bom',
        STRONG: 'Forte',
        VERY_STRONG: 'Muito Forte'
    });
    $translateProvider.preferredLanguage('pt_BR');
});

