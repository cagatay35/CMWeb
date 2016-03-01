package org.cmweb.services.security.impl;

import org.cmweb.entity.CustomerEntity;
import org.cmweb.entity.CustomerTokenEntity;
import org.cmweb.repository.ITokenHandlerRepository;
import org.cmweb.services.security.ITokenHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "tokenHandlerService")
public class TokenHandlerService implements ITokenHandlerService {

    @Autowired
    private ITokenHandlerRepository tokenHandlerDao;

    public CustomerEntity getUserByToken(String token) {
        CustomerTokenEntity customerTokenEntity = tokenHandlerDao.getUserByToken(token);
        if (customerTokenEntity != null && customerTokenEntity.getCustomer() != null) {
            return  customerTokenEntity.getCustomer();
        } else {
            return null;
        }

    }
}
