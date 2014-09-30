(function () {
    'use strict';

    angular
        .module('app')
        .controller('register', register);

    register.$inject = ['$http', '$window'];

    /* @ngInject */
    function register($http, $window) {
        /* jshint validthis: true */
        var vm = this;

        vm.activate = activate;
        vm.title = 'register';
        vm.competing = false;
        vm.contestantName = "";

        vm.postInfo = function () {
            $http({
                method: 'POST',
                url: '/register',
                data: {name: vm.name, password: vm.password, contestant: {name: vm.contestantName}}
            }).success(function (data) {
//              $window.location.replace("/contestants/" + data.id);
            });
        };

        activate();

        ////////////////

        function activate() {
        }
    }
})();