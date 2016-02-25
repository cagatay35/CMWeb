package org.cmweb.services;

import org.cmweb.data.CustomerData;

public interface ILoginService {

    public CustomerData login(String username, String password);

}
