package com.agh.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsId orderDetailsId;
    @Column(name = "unit_price")
    private float unitPrice;
    @Column(name = "quantity")
    private short quantity;
    @Column(name = "discount")
    private float discount;


    public OrderDetails() {
    }

    public OrderDetailsId getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(OrderDetailsId orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}
