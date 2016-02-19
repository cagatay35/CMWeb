package org.cmweb.services.impl;

import org.cmweb.dao.LoginDao;
import org.cmweb.model.User;
import org.cmweb.services.LoginService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;


@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {


    LoginDao loginDao;

    public User login(String username, String password) {
        return loginDao.login(username, password);
    }

    @Required
    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
