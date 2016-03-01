package org.cmweb.facades.customer.impl;

import org.apache.log4j.Logger;
import org.cmweb.constants.SessionConstants;
import org.cmweb.data.CustomerData;
import org.cmweb.facades.customer.ICustomerFacade;
import org.cmweb.services.session.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerFacade implements ICustomerFacade {

    private Logger LOG = Logger.getLogger(CustomerFacade.class);


    @Autowired
    ISessionService sessionService;

    public void loginSuccess() {
        LOG.debug("TODO LOGIN SUCCESS THINGS");
    }

    public CustomerData getCurrentCustomer() {
        return sessionService.getFromSession(SessionConstants.CUSTOMER_SESSION_KEY);
    }


    public void setCustomer(CustomerData customerData) {
       sessionService.setAttribute(SessionConstants.CUSTOMER_SESSION_KEY,customerData);
    }
}
