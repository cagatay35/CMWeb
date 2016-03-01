package org.cmweb.facades.customer;

import org.cmweb.data.CustomerData;

public interface ICustomerFacade {
    void loginSuccess();
    CustomerData getCurrentCustomer();
}
