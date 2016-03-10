package org.cmweb.services.customer;

import org.cmweb.data.CustomerData;
import org.cmweb.exceptions.CMException;

import java.util.List;

public interface ICustomerService {
    List<CustomerData> getAllCustomers();

    CustomerData getCustomerById(int id) throws CMException;
}
