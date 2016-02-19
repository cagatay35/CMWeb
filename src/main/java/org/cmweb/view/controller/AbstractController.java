package org.cmweb.view.controller;

public class AbstractController {

    private static final String REDIRECT_PREFIX = "redirect:";

    public String redirectToPage(String page) {
        return REDIRECT_PREFIX + page;
    }


}
