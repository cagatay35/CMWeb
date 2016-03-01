package org.cmweb.services.security;

import org.cmweb.entity.CustomerEntity;

public interface ITokenHandlerService {

    CustomerEntity getUserByToken(String token);



}
