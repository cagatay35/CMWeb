package org.cmweb.model;

import java.io.Serializable;

public class Customer extends User implements Serializable{

    public Customer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
