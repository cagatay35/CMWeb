package org.cmweb.services.customer.impl;

import org.cmweb.converters.CustomerConverter;
import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.exceptions.CMException;
import org.cmweb.repository.ICustomerRepository;
import org.cmweb.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CustomerService")
public class CustomerService implements ICustomerService {


    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;

    public List<CustomerData> getAllCustomers() {
        customerRepository.getAllCustomers();
        return null;
    }

    public CustomerData getCustomerByUsername(String username) {
        return customerConverter.convert(customerRepository.getCustomerByUsername(username));
    }

    public CustomerData getCustomerById(int id) throws CMException{
        return customerConverter.convert(customerRepository.getCustomerById(id));
    }
}
