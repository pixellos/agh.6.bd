package com.agh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shippers")
public class Shippers {

    @Id
    @Column(name = "shipper_id")
    private short shipperId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;

    @OneToMany(targetEntity = Orders.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Orders> orders;

    public short getShipperId() {
        return shipperId;
    }

    public void setShipperId(short shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
