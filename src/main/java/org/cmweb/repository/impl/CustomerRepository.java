package org.cmweb.repository.impl;

import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.entity.RoleEntity;
import org.cmweb.exceptions.CMException;
import org.cmweb.repository.ICustomerRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class CustomerRepository extends GenericRepository<CustomerEntity> implements ICustomerRepository {


    public CustomerRepository() {
        setEntityClass(CustomerEntity.class);
    }

    public List<CustomerEntity> getAllCustomers() {
        return findAll();
    }

    public CustomerEntity getCustomerById(int id) throws CMException {
        try {
            CustomerEntity customerEntity = get(id);
            return customerEntity;
        } catch (Exception e) {
            throw new CMException(e);
        }
    }

    public List<String> getCustomerRolesByCustomerId(int id) {
        CustomerEntity customerEntity = get(id);
        return convertRoles(customerEntity.getCustomerRoles());
    }

    public CustomerEntity getCustomerByUsername(String username) {
        Session session = openSession();
        Criteria criteria = session.createCriteria(CustomerEntity.class);
        criteria.createAlias("customerSecurity", "security");
        criteria.add(Restrictions.eq("security.username", username));
        criteria.setFetchSize(1);
        List<CustomerEntity> customers = criteria.list();
        session.close();
        if (customers != null && customers.size() != 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }

    public List<String> getCustomerRolesByUsername(String username) {
        CustomerEntity customerEntity = getCustomerByUsername(username);
        return customerEntity == null ? Collections.EMPTY_LIST : convertRoles(customerEntity.getCustomerRoles());

    }


    private List<String> convertRoles(Collection<RoleEntity> customerRoles) {
        List<String> roles = new ArrayList<String>();
        if (customerRoles != null) {
            for (RoleEntity role : customerRoles) {
                roles.add(role.getRoleName());
            }
        }

        return roles;

    }
}
