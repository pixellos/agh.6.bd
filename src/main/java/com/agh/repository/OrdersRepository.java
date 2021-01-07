package com.agh.repository;

import com.agh.model.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdersRepository extends AbstractRepository {

    public List<Orders> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o" +
                        " LEFT JOIN FETCH o.customers c" +
                        " LEFT JOIN FETCH o.employees e" +
                        " LEFT JOIN FETCH o.shippers s ", Orders.class)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

    public Optional<Orders> getById(Short orderId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<Orders> order = session
                .createQuery("SELECT o FROM Orders o WHERE o.orderId=:orderId", Orders.class)
                .setParameter("orderId", orderId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return order;
    }

    public List<Orders> getAllByCustomerId(String customerId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o" +
                        " LEFT JOIN FETCH o.customers c" +
                        " LEFT JOIN FETCH o.employees e" +
                        " LEFT JOIN FETCH o.shippers s " +
                        " WHERE c.customerId=:customerId", Orders.class)
                .setParameter("customerId", customerId)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

    public List<Orders> getAllByEmployeeId(Short employeeId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o" +
                        " LEFT JOIN FETCH o.customers c" +
                        " LEFT JOIN FETCH o.employees e" +
                        " LEFT JOIN FETCH o.shippers s " +
                        " WHERE e.employeeId=:employeeId", Orders.class)
                .setParameter("employeeId", employeeId)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

    public List<Orders> getAllByShipperId(Short shipperId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o" +
                        " LEFT JOIN FETCH o.customers c" +
                        " LEFT JOIN FETCH o.employees e" +
                        " LEFT JOIN FETCH o.shippers s " +
                        " WHERE s.shipperId=:shipperId", Orders.class)
                .setParameter("shipperId", shipperId)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

    public void persist(Orders order) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.persist(order);
        transaction.commit();
        session.close();
    }

}
