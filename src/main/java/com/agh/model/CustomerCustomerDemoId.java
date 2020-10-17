package com.agh.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CustomerCustomerDemoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerDemographics customerDemographics;

    public CustomerCustomerDemoId() {
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public CustomerDemographics getCustomerDemographics() {
        return customerDemographics;
    }

    public void setCustomerDemographics(CustomerDemographics customerDemographics) {
        this.customerDemographics = customerDemographics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerCustomerDemoId that = (CustomerCustomerDemoId) o;

        if (customers != null ? !customers.equals(that.customers) : that.customers != null) return false;
        return customerDemographics != null ? customerDemographics.equals(that.customerDemographics) : that.customerDemographics == null;
    }

    @Override
    public int hashCode() {
        int result = customers != null ? customers.hashCode() : 0;
        result = 31 * result + (customerDemographics != null ? customerDemographics.hashCode() : 0);
        return result;
    }
}
