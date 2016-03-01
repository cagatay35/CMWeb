package org.cmweb.services.session.impl;

import org.cmweb.services.session.ISessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Service(value = "sessionService")
public class SessionService implements ISessionService {


    public <T> T getFromSession(String key) {
        HttpSession session = getSession();

        if (session == null) {
            return null;
        } else {
            return session.getAttribute(key) == null ? null : (T) session.getAttribute(key);
        }
    }

    public <T> void setAttribute(String key, T val) {
        getSession().setAttribute(key, val);
    }


    public HttpSession getSession() {
        HttpServletRequest request = getRequest();
        HttpSession session = (request == null) ? null : request.getSession();
        return session;
    }

    public <T> Map<String, T> getAllAttributes() {
        return null;
    }

    public String getSessionId() {
        return null;
    }

    public void removeAttribute(String key) {

    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
