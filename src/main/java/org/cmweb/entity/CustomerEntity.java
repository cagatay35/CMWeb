package org.cmweb.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "customer", schema = "")
public class CustomerEntity {


    private int customerId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Collection<AddresEntity> addresByCustomerId;
    private CustomerSecurityEntity customerSecurity;
    private Collection<CustomerContactEntity> customerContactsByCustomerId;
    private Collection<RoleEntity> customerRoles;

    @Id
    @Column(name = "customer_id", nullable = false, insertable = true, updatable = true)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<AddresEntity> getAddresByCustomerId() {
        return addresByCustomerId;
    }

    public void setAddresByCustomerId(Collection<AddresEntity> addresByCustomerId) {
        this.addresByCustomerId = addresByCustomerId;
    }

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public CustomerSecurityEntity getCustomerSecurity() {
        return customerSecurity;
    }

    public void setCustomerSecurity(CustomerSecurityEntity customerSecurity) {
        this.customerSecurity = customerSecurity;
    }


    @Column(name = "birth_date", nullable = false, insertable = true, updatable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<CustomerContactEntity> getCustomerContactsByCustomerId() {
        return customerContactsByCustomerId;
    }

    public void setCustomerContactsByCustomerId(Collection<CustomerContactEntity> customerContactsByCustomerId) {
        this.customerContactsByCustomerId = customerContactsByCustomerId;
    }

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="customers")
    public Collection<RoleEntity> getCustomerRoles() {
        return customerRoles;
    }

    public void setCustomerRoles(Collection<RoleEntity> customerRoles) {
        this.customerRoles = customerRoles;
    }

}
