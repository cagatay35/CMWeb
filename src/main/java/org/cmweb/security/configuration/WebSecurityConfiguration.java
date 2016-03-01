package org.cmweb.security.configuration;

import org.cmweb.services.security.ITokenAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier(value = "tokenAuthService")
    private ITokenAuthService tokenAuthService;
}
