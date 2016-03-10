package org.cmweb.repository;

import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.exceptions.CMException;

import java.util.List;

public interface ICustomerRepository {
    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(int id) throws CMException;

    List<String> getCustomerRolesByCustomerId(int id);

    CustomerEntity getCustomerByUsername(String username);

    List<String> getCustomerRolesByUsername(String username);

}
