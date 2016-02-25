package org.cmweb.repository.impl;

import org.cmweb.entity.CustomerEntity;
import org.cmweb.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "loginDao")
public class CustomerRepository extends GenericRepository<CustomerEntity> implements ICustomerRepository {

}
