package org.cmweb.repository.impl;

import org.cmweb.entity.CustomerEntity;
import org.cmweb.repository.ILoginRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LoginRepository extends AbstractHibernateRepository implements ILoginRepository {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    public CustomerEntity login(String username, String password) {
        Session session = openSession();
        Criteria criteria = session.createCriteria(CustomerEntity.class);
        criteria.createAlias("customerSecurity","security");
        criteria.add(Restrictions.eq("security.username", username));
        criteria.setFetchSize(1);
        List<CustomerEntity> customers = criteria.list();
        session.close();
        if (customers != null && customers.size() != 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }


}
