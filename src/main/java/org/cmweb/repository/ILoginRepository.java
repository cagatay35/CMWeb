package org.cmweb.repository;

import org.cmweb.data.UserData;
import org.cmweb.entity.CustomerEntity;

public interface ILoginRepository {
    public CustomerEntity login(String username, String password);
}
