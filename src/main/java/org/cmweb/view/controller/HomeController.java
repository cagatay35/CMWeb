package org.cmweb.view.controller;


import org.cmweb.constants.ControllerConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends AbstractController{


    @Override
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String enterStep(HttpServletRequest request, Model model) {
        model.addAttribute("user",getCustomer());
        return ControllerConstants.HOME_PAGE;
    }


}
