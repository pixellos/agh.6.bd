package com.agh.service;

import com.agh.model.Customers;
import com.agh.model.Employees;
import com.agh.model.Orders;
import com.agh.model.Shippers;
import com.agh.repository.OrdersRepository;
import com.agh.request.CreateOrderRequest;
import com.agh.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ShippersService shippersService;
    private final EmployeesService employeesService;
    private final CustomersService customersService;
    private final ValidationService validationService;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, ShippersService shippersService,
                         EmployeesService employeesService, CustomersService customersService, ValidationService validationService) {
        this.ordersRepository = ordersRepository;
        this.shippersService = shippersService;
        this.employeesService = employeesService;
        this.customersService = customersService;
        this.validationService = validationService;
    }

    public List<Orders> getAll() {
        return ordersRepository.getAll();
    }

    public Orders getById(Short orderId) {
        return ordersRepository.getById(orderId).orElseThrow(IllegalArgumentException::new);
    }

    public List<Orders> getAllByCustomerId(String customerId) {
        return ordersRepository.getAllByCustomerId(customerId);
    }

    public List<Orders> getAllByEmployeeId(Short employeeId) {
        return ordersRepository.getAllByEmployeeId(employeeId);
    }

    public List<Orders> getAllByShipperId(Short shipperId) {
        return ordersRepository.getAllByShipperId(shipperId);
    }

    public void create(CreateOrderRequest request) {
        Orders order = new Orders();
        Shippers shipper = shippersService.getById(request.getShipperId());
        Employees employee = employeesService.getById(request.getEmployeeId());
        Customers customer = customersService.getById(request.getCustomerId());

        order.setShippers(shipper);
        order.setEmployees(employee);
        order.setCustomers(customer);

        order.setRequiredDate(DateConverter.toDate(request.getRequiredDate()));
        order.setShippedDate(DateConverter.toDate(request.getShippedDate()));
        order.setFreight(request.getFreight());
        order.setShipName(request.getShipName());
        order.setShipAddress(request.getShipAddress());
        order.setShipCity(request.getShipCity());
        order.setShipRegion(request.getShipRegion());
        order.setShipPostalCode(request.getShipPostalCode());
        order.setShipCountry(request.getShipCountry());
        validationService.validate(order);
        ordersRepository.persist(order);
    }
}
