package org.cmweb.services.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ISessionService {

    <T> T getFromSession(String key);
    <T> void setAttribute(String key,T val);
    HttpServletRequest getRequest();
    HttpSession getSession();
    <T> Map<String, T> getAllAttributes();
    String getSessionId();
    void removeAttribute(String key);
}
