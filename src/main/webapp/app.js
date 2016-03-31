var myApp = angular.module("myApp", [ 'ngRoute' ]);

myApp.controller('mainController', [ '$scope', '$log', '$http', '$location',
		'fileUpload', function($scope, $log, $http, $location, fileUpload)
			{

				$scope.uploadFunc = function()
					{
						var file = $scope.myFile;
						var uploadUrl = 'upload';
						fileUpload.uploadFileToUrl(file, uploadUrl, $scope);
					}

			} ]);

myApp.controller('extractController', [ '$scope', '$log', '$http',
		function($scope, $log, $http)
			{

				// $scope.excel =
				// {"key":"356ca5c1-80ed-4a9f-a7ea-5c31bbb75681","table":[{"folderStructure":"R5.1/Sprint1/Jira-796","mode":"Add","tcID":"","tcName":"","tcDescription":"","tcSteps":"","tcExpectedResult":"","tcStatus":""},{"folderStructure":"R5.1/Sprint1/Jira-796","mode":"Update","tcID":"TC1024","tcName":"","tcDescription":"","tcSteps":"","tcExpectedResult":"","tcStatus":"Pass/Fail"},{"folderStructure":"R5.1/Sprint2/Jira-863","mode":"Add","tcID":"","tcName":"","tcDescription":"","tcSteps":"","tcExpectedResult":"","tcStatus":""}]};

				// console.log($scope.excel);
				// console.log("hey yo");
				// console.log($http.post("http://localhost:8080/training/display"));
				// $scope.excel =
				// $http.post("http://localhost:8080/training/display",,{});

				$http.post('display').success(function(data)
					{
						$scope.excel = data;
					});
				console.log($scope.excel);

			} ]);

myApp.controller('displayController', [
		'$scope',
		'$log',
		'$http',
		'$routeParams',
		function($scope, $log, $http, $routeParams)
			{

				$scope.isDisabled = true;
				$http.post(
						'display/' + $routeParams.key + '/' + $routeParams.ext)
						.success(function(data)
							{
								$scope.excel = data;
								$scope.isDisabled = false;
							});

				$scope.confirmation = function()
					{
						$scope.isDisabled = true;
						//return;
						//alert("Yo this is try");
						/*$http.post('confirm', $scope.excel).success(
								function(data)
									{
										$scope.excel = data;
									});*/
						
						$http({
						    url: 'confirm',
						    method: "POST",
						    data: $scope.excel, //this is your json data string
						    headers: {
						       'Content-type': 'application/json'
						    },
						    responseType: 'arraybuffer'
						}).success(function (data, status, headers, config) {
						    var blob = new Blob([data], {type: "application/vnd.ms-excel",filename:"newTestCase.xls"});
						    var objectUrl = URL.createObjectURL(blob);
						    window.open(objectUrl);
						}).error(function (data, status, headers, config) {
						    //upload failed
						});
					}
						
		} ]);

myApp.controller('confirmController', [
		'$scope',
		'$log',
		'$http',
		'$routeParams',
		function($scope, $log, $http, $routeParams)
			{

				$http.post(
						'confirm/' + $routeParams.key + '/' + $routeParams.ext)
						.success(function(data)
							{
								$scope.excel = data;
							});

			} ]);

myApp.config(function($routeProvider)
	{
		$routeProvider.when('/', {
			templateUrl : 'form.html',
			controller : 'mainController'
		})

		.when('/extract', {
			templateUrl : 'extract.html',
		})

		.when('/display/:key/:ext', {
			templateUrl : 'display.html',
		})

		.when('/confirm/:key/:ext', {
			templateUrl : 'displayConf.html',
			controller : 'confirmController'
		})

	});

myApp.directive("uploadedContent", function()
	{
		return {
			restrict : 'AECM',
			templateUrl : 'directive/table.html',
			scope : {
				excelObject : "="
			}
		};

	});

myApp.directive('fileModel', [ '$parse', function($parse)
	{
		return {
			restrict : 'A',
			link : function(scope, element, attrs)
				{
					var model = $parse(attrs.fileModel);
					var modelSetter = model.assign;

					element.bind('change', function()
						{
							scope.$apply(function()
								{
									modelSetter(scope, element[0].files[0]);
								});
						});
				}
		};
	} ]);

myApp.service('fileUpload', [ '$http', '$location', function($http, $location)
	{
		this.uploadFileToUrl = function(file, uploadUrl, $scope)
			{
				var fd = new FormData();
				fd.append('fileToUpload', file);
				$http.post(uploadUrl, fd, {
					transformRequest : angular.identity,
					headers : {
						'Content-Type' : undefined
					}
				}).success(function(data)
					{
						if (data.status == "success")
							{
								var key = data.key.replace(".", "/");
								$location.path("/display/" + key);
							}
						else
							{
								$scope.error = "Error: " + data.key;
							}
					}).error(function(data)
					{
						// console.log(data);
					});
			}
	} ]);
