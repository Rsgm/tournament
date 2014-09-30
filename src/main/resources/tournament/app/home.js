(function () {
    'use strict';

    angular
        .module('app')
        .controller('home', home);

    home.$inject = [];

    /* @ngInject */
    function home() {
        /* jshint validthis: true */
        var vm = this;

        vm.activate = activate;
        vm.title = 'home';

        activate();

        ////////////

        function activate() {
        }
    }
})();