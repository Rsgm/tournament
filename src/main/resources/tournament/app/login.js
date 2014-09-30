(function () {
    'use strict';

    angular
        .module('app')
        .controller('login', login);

    login.$inject = ['$http', '$window'];

    /* @ngInject */
    function login($http, $window) {
        /* jshint validthis: true */
        var vm = this;

        vm.activate = activate;
        vm.title = 'login';

        vm.postInfo = function () {
            $http({
                method: 'POST',
                url: '/login',
                data: {name: vm.name, password: vm.password}
            }).success(function (data) {
//                $window.location.replace("/contestants/" + data.id);
            });
        };

        activate();

        ////////////////

        function activate() {
        }
    }
})();