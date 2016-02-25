package org.cmweb.data;

import java.io.Serializable;

public class CustomerData extends UserData implements Serializable{

    public CustomerData() {

    }

    public CustomerData(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
