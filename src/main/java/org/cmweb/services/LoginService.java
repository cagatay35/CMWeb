package org.cmweb.services;

import org.cmweb.model.User;

public interface LoginService {

    public User login(String username, String password);

}
