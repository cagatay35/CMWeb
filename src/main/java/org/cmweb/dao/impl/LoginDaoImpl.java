package org.cmweb.dao.impl;

import org.cmweb.dao.LoginDao;
import org.cmweb.model.Customer;
import org.cmweb.model.User;
import org.springframework.stereotype.Repository;


@Repository(value = "loginDao")
public class LoginDaoImpl implements LoginDao {

    public User login(String username, String password) {
        return new Customer(username, password, null);
    }
}
