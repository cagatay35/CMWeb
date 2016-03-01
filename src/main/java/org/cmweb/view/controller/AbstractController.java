package org.cmweb.view.controller;

import org.cmweb.constants.SessionConstants;
import org.cmweb.data.CustomerData;
import org.cmweb.services.session.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public abstract class AbstractController {

    private static final String REDIRECT_PREFIX = "redirect:";

    @Autowired
    private ISessionService sessionService;

    public String redirectToPage(String page) {
        return REDIRECT_PREFIX + page;
    }

    public abstract String enterStep(HttpServletRequest request, Model model);

    public CustomerData getCustomer() {
        return (CustomerData)sessionService.getFromSession(SessionConstants.CUSTOMER_SESSION_KEY);
    }

    public void setCustomer(CustomerData customerData) {
        sessionService.setAttribute(SessionConstants.CUSTOMER_SESSION_KEY, customerData);
    }


}
