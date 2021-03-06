package com.agh.service;

import com.agh.model.OrderDetails;
import com.agh.model.OrderDetailsId;
import com.agh.model.Orders;
import com.agh.model.Products;
import com.agh.repository.OrderDetailsRepository;
import com.agh.request.CreateOrderDetailsRequest;
import com.agh.request.UpdateOrderDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final OrdersService ordersService;
    private final ProductsService productsService;
    private final ValidationService validationService;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, OrdersService ordersService, ProductsService productsService,
                               ValidationService validationService) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.ordersService = ordersService;
        this.productsService = productsService;
        this.validationService = validationService;
    }

    public List<OrderDetails> getAll() {
        return orderDetailsRepository.getAll();
    }

    public List<OrderDetails> getByOrderId(Short orderId) {
        return orderDetailsRepository.getByOrderId(orderId);
    }

    public List<OrderDetails> getByProductId(Short productId) {
        return orderDetailsRepository.getByProductId(productId);
    }

    public OrderDetails getByProductIdAndOrderId(Short productId, Short orderId) {
        return  orderDetailsRepository.getByProductIdAndOrderId(productId, orderId).orElseThrow(IllegalArgumentException::new);
    }

    public List<OrderDetails> getByProductCategory(String categoryName) {
        return orderDetailsRepository.getByProductCategory(categoryName);
    }

    public List<OrderDetails> getBySupplierId(Short supplierId) {
        return orderDetailsRepository.getBySupplierId(supplierId);
    }

    public void create(CreateOrderDetailsRequest request) {
        OrderDetails orderDetails = new OrderDetails();
        OrderDetailsId orderDetailsId = new OrderDetailsId();

        Orders order = ordersService.getById(request.getOrderId());
        Products product = productsService.getById(request.getProductId());
        orderDetailsId.setOrders(order);
        orderDetailsId.setProducts(product);
        orderDetails.setOrderDetailsId(orderDetailsId);

        orderDetails.setUnitPrice(request.getUnitPrice());
        orderDetails.setQuantity(request.getQuantity());
        orderDetails.setDiscount(request.getDiscount());

        validationService.validate(orderDetails);
        orderDetailsRepository.persist(orderDetails);
    }

    public void update(UpdateOrderDetailsRequest request) {
        OrderDetails orderDetails = getByProductIdAndOrderId(request.getProductId(), request.getOrderId());

        orderDetails.setUnitPrice(request.getUnitPrice());
        orderDetails.setQuantity(request.getQuantity());
        orderDetails.setDiscount(request.getDiscount());

        validationService.validate(orderDetails);
        orderDetailsRepository.update(orderDetails);
    }

    public void deleteByProductIdAndOrderId(Short productId, Short orderId) {
        OrderDetails orderDetails = getByProductIdAndOrderId(productId, orderId);
        orderDetailsRepository.delete(orderDetails);
    }
}
