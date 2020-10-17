package com.agh.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer_customer_demo")
public class CustomerCustomerDemo {

    @EmbeddedId
    private CustomerCustomerDemoId customerCustomerDemoId;

    public CustomerCustomerDemo() {
    }

    public CustomerCustomerDemoId getCustomerCustomerDemoId() {
        return customerCustomerDemoId;
    }

    public void setCustomerCustomerDemoId(CustomerCustomerDemoId customerCustomerDemoId) {
        this.customerCustomerDemoId = customerCustomerDemoId;
    }
}
