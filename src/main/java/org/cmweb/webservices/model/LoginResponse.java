package org.cmweb.webservices.model;

import org.cmweb.data.CustomerData;

public class LoginResponse extends BaseResponse {
    private CustomerData customerData;

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }
}
