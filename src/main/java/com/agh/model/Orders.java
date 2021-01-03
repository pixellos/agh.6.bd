package com.agh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @Column(name = "order_id")
    @SequenceGenerator(name = "orderSEQ", sequenceName = "order_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSEQ")
    private short orderId;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "required_date")
    private LocalDate requiredDate;
    @Column(name = "shipped_date")
    private LocalDate shippedDate;
    @Column(name = "freight")
    private Float freight;
    @Column(name = "ship_name")
    private String shipName;
    @Column(name = "ship_address")
    private String shipAddress;
    @Column(name = "ship_city")
    private String shipCity;
    @Column(name = "ship_region")
    private String shipRegion;
    @Column(name = "ship_postal_code")
    private String shipPostalCode;
    @Column(name = "ship_country")
    private String shipCountry;

    @ManyToOne(targetEntity = Shippers.class)
    @JoinColumn(name = "ship_via", referencedColumnName = "shipper_id")
    private Shippers shippers;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employees employees;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customers customers;

    @OneToMany(targetEntity = OrderDetails.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderDetails> orderDetails;

    public Orders() {
    }

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public Shippers getShippers() {
        return shippers;
    }

    public void setShippers(Shippers shippers) {
        this.shippers = shippers;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @PrePersist
    public void prePersist() {
        orderDate = LocalDate.now();
    }
}
