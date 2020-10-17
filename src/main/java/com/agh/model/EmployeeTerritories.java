package com.agh.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_territories")
public class EmployeeTerritories {

    @EmbeddedId
    private EmployeeTerritoriesId employeeTerritoriesId;

    public EmployeeTerritories() {
    }

    public EmployeeTerritoriesId getEmployeeTerritoriesId() {
        return employeeTerritoriesId;
    }

    public void setEmployeeTerritoriesId(EmployeeTerritoriesId employeeTerritoriesId) {
        this.employeeTerritoriesId = employeeTerritoriesId;
    }
}
