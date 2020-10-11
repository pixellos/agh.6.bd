package com.agh.model;

import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territories {
    @Id
    @Column(name = "territory_id")
    private String territoryId;
    @Column(name = "territory_description")
    private String territoryDescription;

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
}
