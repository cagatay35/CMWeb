package org.cmweb.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "district", schema = "")
public class DistrictEntity {
    private int districtId;
    private String districtName;
    private int cityId;
    private Collection<AddresEntity> addresByDistrictId;
    private CityEntity cityByCityId;

    @Id
    @Column(name = "district_id", nullable = false, insertable = true, updatable = true)
    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "district_name", nullable = false, insertable = true, updatable = true, length = 100)
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictEntity that = (DistrictEntity) o;

        if (districtId != that.districtId) return false;
        if (districtName != null ? !districtName.equals(that.districtName) : that.districtName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = districtId;
        result = 31 * result + (districtName != null ? districtName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "city_id", nullable = false, insertable = false, updatable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @OneToMany(mappedBy = "districtByDistrictId")
    public Collection<AddresEntity> getAddresByDistrictId() {
        return addresByDistrictId;
    }

    public void setAddresByDistrictId(Collection<AddresEntity> addresByDistrictId) {
        this.addresByDistrictId = addresByDistrictId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
