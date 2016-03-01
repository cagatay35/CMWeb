package org.cmweb.services.login;

import org.cmweb.data.CustomerData;

public interface ILoginService {

    public CustomerData login(String username, String password);

}
