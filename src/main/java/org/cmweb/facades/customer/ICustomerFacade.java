package org.cmweb.facades.customer;

import org.cmweb.data.CustomerData;
import org.cmweb.exceptions.CMException;

import java.util.List;

public interface ICustomerFacade {
    void loginSuccess();

    CustomerData getCurrentCustomer();

    List<CustomerData> getAllCustomers();

    CustomerData getCustomerById(int id) throws CMException;
}