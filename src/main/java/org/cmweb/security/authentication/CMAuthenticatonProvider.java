package org.cmweb.security.authentication;

import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerTokenEntity;
import org.cmweb.services.login.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class CMAuthenticatonProvider implements AuthenticationProvider {

    @Autowired
    LoginService loginService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomerData customerData = loginService.login(username, password);

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, populateAuthorities(customerData));
        return auth;
    }

    public boolean supports(Class<?> authClass) {
        return CustomerTokenEntity.class.equals(authClass);
    }


    private List<GrantedAuthority> populateAuthorities(CustomerData customerData) {
        return null;
    }
}
