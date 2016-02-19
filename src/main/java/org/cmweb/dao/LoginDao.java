package org.cmweb.dao;

import org.cmweb.model.User;

public interface LoginDao {
    public User login(String username, String password);
}
