package org.cmweb.services.security.impl;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.cmweb.repository.ICustomerRepository;
import org.cmweb.services.security.ITokenAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "tokenAuthService")
public class TokenAuthService implements ITokenAuthService {

    private TokenHandlerService handlerService;

    @Autowired
    private ICustomerRepository customerRepository;

    public String createToken(int id) {
        List<String> roles = customerRepository.getCustomerRolesByCustomerId(id);

        return
                Jwts.builder().setSubject(String.valueOf(id))
                        .claim("roles", roles).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }

    public List<String> getCustomerRolesByUsername(String username) {
        return customerRepository.getCustomerRolesByUsername(username);
    }

}
