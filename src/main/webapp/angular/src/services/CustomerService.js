/**
 * Created by cagatay.gokcel on 3.3.2016.
 */
'use strict'
App.service('CustomerService', ['$http', '$q', function ($http, $q) {
    console.log("service did this run");

    return {
        fetchCustomerById: function (customerId) {
           return $http.get('/rest/customer/getById' + "/" + customerId).then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    return $q.reject(errResponse);
                }
            );
        },
        recordCustomer: function (customer) {
        },
        fetchAllCustomers: function () {
            return $http.get('/rest/customer/getAll').then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error("Error while fetching customer by id e; " + errResponse);
                    return $q.reject(errResponse);
                }
            );
        },
        deleteCustomer: function () {

        }
    }
}
]);
