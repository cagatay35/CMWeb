package org.cmweb.view.controller;

import org.cmweb.constants.ControllerConstants;
import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.cmweb.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends AbstractController {


    @Autowired
    ILoginService ILoginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {

        String username = request.getParameter("itUserName").toString();
        String password = request.getParameter("itPassword").toString();

        CustomerData user = ILoginService.login(username, password);
        if (user != null) {
            setCustomer(user);
            return redirectToPage(ControllerConstants.HOME_PAGE);
        } else {
            return ControllerConstants.LOGIN_PAGE;
        }


    }

    private void populateUser(Model model, CustomerData user) {
        model.addAttribute("user", getCustomer());
    }


    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String enterStep(HttpServletRequest request, Model model) {
        return ControllerConstants.LOGIN_PAGE;
    }
}
