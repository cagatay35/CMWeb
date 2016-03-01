package org.cmweb.entity;


import org.cmweb.constants.HqlQueries;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "customer_token", schema = "")
@NamedQueries({@NamedQuery(name = HqlQueries.DEACTIVATE_ALL_TOKENS_BY_USER, query = HqlQueries.DEACTIVATE_ALL_TOKENS_BY_USER_QUERY),
        @NamedQuery(name = HqlQueries.CHANGE_TOKEN_STATUS, query = HqlQueries.CHANGE_TOKEN_STATUS_QUERY)})
public class CustomerTokenEntity {

    private int tokenId;

    private CustomerEntity customer;

    private String token;

    private String ip;

    private Date creationDate;

    private int status;


    @Id
    @Column(name = "token_id")
    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }


    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
