package com.agh.service;

import com.agh.model.OrderDetails;
import com.agh.model.Orders;
import com.agh.model.Products;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationService {

    public void validate(Products product) {
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }

        if (product.getQuantityPerUnit() == null || product.getQuantityPerUnit().trim().isEmpty()) {
            throw new IllegalArgumentException("Quantity per unit cannot be empty");
        }

        if (product.getUnitPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Unit price has to be greater than 0");
        }

        if (product.getUnitsInStock() <= 0 || product.getUnitsOnOrder() <= 0) {
            throw new IllegalArgumentException("Units in stock and Units on order has to be greater than 0");
        }
    }

    public void validate(Orders order) {
        if (order.getOrderDate().isAfter(order.getRequiredDate())) {
            throw new IllegalArgumentException("Order date has to be before required date");
        }

        if (order.getShippedDate().isAfter(order.getRequiredDate())) {
            throw new IllegalArgumentException("Shipped date has to be before required date");
        }

        if (order.getFreight() <= 0) {
            throw new IllegalArgumentException("Freight has to be greater than 0");
        }

        if (order.getShipName() == null || order.getShipName().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship name cannot be empty");
        }

        if (order.getShipAddress() == null || order.getShipAddress().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship address cannot be empty");
        }

        if (order.getShipCity() == null || order.getShipCity().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship city cannot be empty");
        }

        if (order.getShipRegion() == null || order.getShipRegion().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship region cannot be empty");
        }

        if (order.getShipPostalCode() == null || order.getShipPostalCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship postal code cannot be empty");
        }

        if (order.getShipCountry() == null || order.getShipCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("Ship country cannot be empty");
        }
    }

    public void validate(OrderDetails orderDetails) {
        if (orderDetails.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity has to be greater than 0");
        }

        if (orderDetails.getUnitPrice() <= 0) {
            throw new IllegalArgumentException("Unit price has to be greater than 0");
        }

        if (orderDetails.getOrderDetailsId().getOrders() == null) {
            throw new IllegalArgumentException("OrderDetails has to be in relationship with Order");
        }

        if (orderDetails.getOrderDetailsId().getProducts() == null) {
            throw new IllegalArgumentException("OrderDetails has to be in relationship with Product");
        }
    }
}
