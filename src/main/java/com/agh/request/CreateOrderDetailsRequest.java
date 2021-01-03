package com.agh.request;

public class CreateOrderDetailsRequest {
    private Short orderId;
    private Short productId;

    private Float unitPrice;
    private Short quantity;
    private Float discount;

    public Short getOrderId() {
        return orderId;
    }

    public void setOrderId(Short orderId) {
        this.orderId = orderId;
    }

    public Short getProductId() {
        return productId;
    }

    public void setProductId(Short productId) {
        this.productId = productId;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
