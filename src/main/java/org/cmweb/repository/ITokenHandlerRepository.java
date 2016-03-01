package org.cmweb.repository;

import org.cmweb.entity.CustomerEntity;
import org.cmweb.entity.CustomerTokenEntity;
import org.cmweb.enums.TokenStatusEnum;

public interface ITokenHandlerRepository {
    CustomerTokenEntity getUserByToken(String token);
    int deactivateAllTokensByUser(CustomerEntity customerEntity);
    void changeStatusOfToken(String token , TokenStatusEnum tokenStatus);
}
