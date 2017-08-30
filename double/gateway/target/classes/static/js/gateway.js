angular.module('gateway', ["ngRoute"]).config(function($httpProvider, $locationProvider) {

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    $locationProvider.html5Mode(true);

}).controller('navigation',

function($http) {

    var self = this;

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
            authorization : "Basic "
            + btoa(credentials.username + ":"
                + credentials.password)
        } : {};

        self.user = ''
        $http.get('user', {
            headers : headers
        }).then(function(response) {
            var data = response.data;
            if (data.name) {
                self.authenticated = true;
                self.user = data.name
                self.admin = data && data.roles && data.roles.indexOf("ROLE_ADMIN")>-1;
            } else {
                self.authenticated = false;
                self.admin = false;
            }
            callback && callback(true);
        }, function() {
            self.authenticated = false;
            callback && callback(false);
        });

    }

    authenticate();

    self.credentials = {};
    self.registerButton = false;
    self.login = function() {
        authenticate(self.credentials, function(authenticated) {
            self.authenticated = authenticated;
            self.error = !authenticated;
        })
    };

    self.logout = function() {
        $http.post('logout', {}).finally(function() {
            self.authenticated = false;
            self.admin = false;
        });
    }

    self.setRegisterPage = function(){
       self.registerButton = true;
       self.RegisterError = null;
    }

    self.setLoginPage = function(){
        self.registerButton = false;
    }

    self.newUser = {};
    self.register = function() {
        $http.post('/register',
            {username : self.newUser.username,
                password : self.newUser.password,
                passwordConfirm: self.newUser.confirmPassword
        }).then(function(response) {
            var data = response.data;

            if(data){
                console.log(data);
                self.RegisterError = true;
                self.RegisterSuccess= false;
                self.RegisterErrorMessage = data;
            }else{
                self.RegisterError = false;
                self.RegisterSuccess = true;
                self.newUser = {};
            }


            self.admin = false;
        });
        //if successful set template to login, otherwise error popup and stay on register
        //after registration reset data

    }

});
