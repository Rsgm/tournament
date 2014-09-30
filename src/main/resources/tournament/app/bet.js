(function () {
    'use strict';

    angular
        .module('app')
        .controller('bet', bet);

    bet.$inject = [];

    /* @ngInject */
    function bet() {
        /* jshint validthis: true */
        var vm = this;

        vm.activate = activate;
        vm.title = 'bet';

        activate();

        ////////////////

        function activate() {
//            vm.table =

        }

        function bet($scope, $http, $window) {
            vm.bet = function () {
                $http({
                    method: 'POST',
                    url: '/bet',
                    data: ''
                }).success(function (data) {
                    $scope.contestants = data;
                });
            }
        }
    }
})();