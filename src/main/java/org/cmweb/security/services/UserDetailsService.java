package org.cmweb.security.services;

import org.cmweb.entity.CustomerEntity;
import org.cmweb.repository.ICustomerRepository;
import org.cmweb.services.security.ITokenAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    ITokenAuthService tokenAuthService;

    @Autowired
    ICustomerRepository customerRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customerEntity = customerRepository.getCustomerByUsername(username);

        if (customerEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;


        UserDetails userDetails = new org.springframework.security.core.userdetails.User(customerEntity.getCustomerSecurity().getEmail(), customerEntity.getCustomerSecurity().getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, populateAuthorities(customerEntity));

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userDetails;
    }

    private List<GrantedAuthority> populateAuthorities(CustomerEntity customerEntity) {
        List<String> roles = tokenAuthService.getCustomerRolesByUsername(customerEntity.getCustomerSecurity().getUsername());
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        return authorityList;
    }
}
