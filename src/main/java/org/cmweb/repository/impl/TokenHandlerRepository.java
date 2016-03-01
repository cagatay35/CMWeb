package org.cmweb.repository.impl;

import org.cmweb.constants.HqlQueries;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.entity.CustomerTokenEntity;
import org.cmweb.enums.TokenStatusEnum;
import org.cmweb.repository.ITokenHandlerRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository(value = "tokenHandlerRepository")
public class TokenHandlerRepository extends AbstractHibernateRepository implements ITokenHandlerRepository {

    // 1 is deactivated token
    // 0 is active token


    public CustomerTokenEntity getUserByToken(String token) {
        Session session = getSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(CustomerTokenEntity.class);
        criteria.add(Restrictions.eq("token", token));
        CustomerTokenEntity customerTokenEntity = (CustomerTokenEntity) criteria.getExecutableCriteria(session).uniqueResult();
        session.close();
        return customerTokenEntity;
    }

    public int deactivateAllTokensByUser(CustomerEntity customerEntity) {
        Session session = getSession();
        Query query = session.getNamedQuery(HqlQueries.DEACTIVATE_ALL_TOKENS_BY_USER);
        query.setParameter(0,"");
        return query.executeUpdate();
    }

    public void changeStatusOfToken(String token , TokenStatusEnum tokenStatus) {
        Query query = getSession().getNamedQuery(HqlQueries.CHANGE_TOKEN_STATUS);
        query.setParameter("token","token");
        query.setParameter("status",tokenStatus);
        query.executeUpdate();
    }

}
