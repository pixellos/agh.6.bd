package com.agh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer_demographics")
public class CustomerDemographics {

    @Id
    @Column(name = "customer_type_id")
    private String customerTypeId;
    @Column(name = "customer_desc")
    private String customerDesc;

    @OneToMany(targetEntity = CustomerCustomerDemo.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CustomerCustomerDemo> customerCustomerDemos;

    public CustomerDemographics() {
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public Set<CustomerCustomerDemo> getCustomerCustomerDemos() {
        return customerCustomerDemos;
    }

    public void setCustomerCustomerDemos(Set<CustomerCustomerDemo> customerCustomerDemos) {
        this.customerCustomerDemos = customerCustomerDemos;
    }
}
