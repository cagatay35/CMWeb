package org.cmweb.services.security;

import java.util.List;

public interface ITokenAuthService {

    public String createToken(int id);
    List<String> getCustomerRolesByUsername(String username);

}
