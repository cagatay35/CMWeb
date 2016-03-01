package org.cmweb.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class RoleEntity {

    private int roleId;

    private String roleName;

    private Collection<CustomerEntity> customers;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
    public Collection<CustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<CustomerEntity> customers) {
        this.customers = customers;
    }


}
