package com.agh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @Column(name = "region_id")
    private short regionId;
    @Column(name = "region_description")
    private String regionDescription;

    @OneToMany(targetEntity = Territories.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Territories> territories;

    public Region() {
    }

    public short getRegionId() {
        return regionId;
    }

    public void setRegionId(short regionId) {
        this.regionId = regionId;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public Set<Territories> getTerritories() {
        return territories;
    }

    public void setTerritories(Set<Territories> territories) {
        this.territories = territories;
    }
}
