/**
 * Created by cagatay.gokcel on 3.3.2016.
 */
'use strict'


App.controller('CustomerController', ['$scope', 'CustomerService', function ($scope, CustomerService) {
    console.log("controller did this run");
    var self = this;
    self.customer = {
        id: null,
        "firstName": 'OZMAN', "email": null
    };
    self.customers = [];


    self.fetchCustomerById= function (customerId) {
        CustomerService.fetchCustomerById(customerId).then(function (response) {
            self.customer = response;
        }, function (errResponse) {
            console.error('Error while fetching customers');
        });
    };
    self.fetchCustomerById(1);

}]);