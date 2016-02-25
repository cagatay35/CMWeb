package org.cmweb.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "")
public class CityEntity {
    private int cityId;
    private String cityName;
    private Collection<DistrictEntity> districtsByCityId;

    @Id
    @Column(name = "city_id", nullable = false, insertable = true, updatable = true)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (cityId != that.cityId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<DistrictEntity> getDistrictsByCityId() {
        return districtsByCityId;
    }

    public void setDistrictsByCityId(Collection<DistrictEntity> districtsByCityId) {
        this.districtsByCityId = districtsByCityId;
    }
}
