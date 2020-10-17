package com.agh.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "territories")
public class Territories {
    @Id
    @Column(name = "territory_id")
    private String territoryId;
    @Column(name = "territory_description")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    @OneToMany(targetEntity = EmployeeTerritories.class, fetch = FetchType.LAZY)
    private Set<EmployeeTerritories> employeeTerritories;

    public Territories() {
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<EmployeeTerritories> getEmployeeTerritories() {
        return employeeTerritories;
    }

    public void setEmployeeTerritories(Set<EmployeeTerritories> employeeTerritories) {
        this.employeeTerritories = employeeTerritories;
    }

}
