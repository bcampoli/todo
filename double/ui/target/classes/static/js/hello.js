angular.module('hello', []).controller('home',

function($http) {
	
	var self = this;
	
	console.log('Loading');

	$http.get('user').then(function(response) {
		var data = response.data;
		if (data.name) {
			self.authenticated = true;
			self.user = data.name
			$http.get('/resource/my-tasks').then(function(response) {
				self.taskList = response.data;
			})
		} else {
			self.authenticated = false;
		}
	}, function() {
		self.authenticated = false;
	});

});
