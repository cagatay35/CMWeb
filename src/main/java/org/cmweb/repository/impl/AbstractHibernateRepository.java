package org.cmweb.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractHibernateRepository {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    protected Session getSession() {
        if (sessionFactory.isClosed()) {
            return sessionFactory.openSession();
        } else {
            return sessionFactory.getCurrentSession();
        }
    }

    protected Session openSession() {
        return sessionFactory.openSession();
    }

    protected void closeSession() {
        sessionFactory.close();
    }
}
