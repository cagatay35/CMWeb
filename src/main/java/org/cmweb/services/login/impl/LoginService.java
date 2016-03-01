package org.cmweb.services.login.impl;

import org.cmweb.converters.CustomerConverter;
import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.repository.ILoginRepository;
import org.cmweb.services.login.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;


@Service(value = "loginService")
public class LoginService implements ILoginService {

    @Autowired
    @Qualifier(value = "customerConverter")
    CustomerConverter customerConverter;

    ILoginRepository loginRepository;

    public CustomerData login(String username, String password) {
        CustomerEntity customerEntity = loginRepository.login(username, password);
        if(customerEntity == null) {
            return  null;
        } else {
            return customerConverter.convert(customerEntity);
        }
    }

    @Required
    public void setLoginRepository(ILoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}
