package org.cmweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "addres", schema = "")
public class AddresEntity {
    private int addressId;
    private String description;
    private String streetName;
    private int customerId;
    private int districtId;
    private CustomerEntity customerByCustomerId;
    private DistrictEntity districtByDistrictId;

    @Id
    @Column(name = "address_id", nullable = false, insertable = true, updatable = true)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "street_name", nullable = true, insertable = true, updatable = true, length = 150)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddresEntity that = (AddresEntity) o;

        if (addressId != that.addressId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (streetName != null ? !streetName.equals(that.streetName) : that.streetName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "customer_id", nullable = false, insertable = false, updatable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "district_id", nullable = false, insertable = false, updatable = false)
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "district_id", nullable = false)
    public DistrictEntity getDistrictByDistrictId() {
        return districtByDistrictId;
    }

    public void setDistrictByDistrictId(DistrictEntity districtByDistrictId) {
        this.districtByDistrictId = districtByDistrictId;
    }
}
