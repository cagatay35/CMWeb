package org.cmweb.view.controller;

import org.cmweb.data.CustomerData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public abstract class AbstractController {

    private static final String CUSTOMER_SESSION_KEY = "CUSTOMER";
    private static final String REDIRECT_PREFIX = "redirect:";

    public String redirectToPage(String page) {
        return REDIRECT_PREFIX + page;
    }

    public abstract String enterStep(HttpServletRequest request, Model model);

    public CustomerData getCustomer() {
        HttpSession session = getSession();
        if (session == null) {
            return null;
        } else {
            return session.getAttribute(CUSTOMER_SESSION_KEY) == null ? null : (CustomerData) session.getAttribute(CUSTOMER_SESSION_KEY);
        }
    }

    public void setCustomer(CustomerData customerData) {
        HttpSession session = getSession();
        if (session != null) {
            session.setAttribute(CUSTOMER_SESSION_KEY, customerData);
        }
    }

    private HttpSession getSession() {
        HttpServletRequest request = getRequest();
        HttpSession session = (request == null) ? null : request.getSession();
        return session;
    }

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
