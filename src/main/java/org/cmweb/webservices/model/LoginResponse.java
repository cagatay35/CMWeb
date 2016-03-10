package org.cmweb.webservices.model;

import org.cmweb.data.CustomerData;

public class LoginResponse extends BaseResponse {
    private CustomerData customerData;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }
}
