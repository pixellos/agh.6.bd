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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeTerritoriesId that = (EmployeeTerritoriesId) o;

        return (employees != null ? employees.equals(that.employees) : that.employees == null) &&
                (territories != null ? territories.equals(that.territories) : that.territories == null);
    }

    @Override
    public int hashCode() {
        int result = employees != null ? employees.hashCode() : 0;
        result = 31 * result + (territories != null ? territories.hashCode() : 0);
        return result;
    }
}
