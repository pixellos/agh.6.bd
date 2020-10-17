package com.agh.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EmployeeTerritoriesId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "territory_id", referencedColumnName = "territory_id")
    private Territories territories;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Territories getTerritories() {
        return territories;
    }

    public void setTerritories(Territories territories) {
        this.territories = territories;
    }
}
