package org.cmweb.view.controller;

import org.cmweb.constants.ControllerConstants;
import org.cmweb.model.User;
import org.cmweb.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends AbstractController {


    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String enterLoginPage(HttpServletRequest request, Model model) {

        model.addAttribute("name", "cagatay");

        return ControllerConstants.LOGIN_PAGE;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {

        String username = request.getAttribute("itUserName").toString();
        String password = request.getAttribute("itPassword").toString();

        User user = loginService.login(username, password);
        if (user != null) {
            populateUser(model, user);
            return redirectToPage(ControllerConstants.HOME_PAGE);
        }

        return ControllerConstants.LOGIN_PAGE;
    }

    private void populateUser(Model model, User user) {

        model.addAttribute("user", user);

    }


}
