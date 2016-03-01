package org.cmweb.services.security.impl;


import org.cmweb.services.security.ITokenAuthService;
import org.springframework.stereotype.Service;

@Service(value = "tokenAuthService")
public class TokenAuthService implements ITokenAuthService{

    private TokenHandlerService handlerService;

}
