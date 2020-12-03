package com.agh.repository;

import com.agh.model.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepository extends AbstractRepository {

    public List<Orders> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o", Orders.class)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

    public List<Orders> getAllByCustomerId(String customerId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Orders> orders = session
                .createQuery("SELECT o FROM Orders o" +
                        " INNER JOIN o.customers c " +
                        " where c.customerId=:customerId", Orders.class)
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
                        " INNER JOIN o.employees e " +
                        " where e.employeeId=:employeeId", Orders.class)
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
                        " INNER JOIN o.shippers s " +
                        " where s.shipperId=:shipperId", Orders.class)
                .setParameter("shipperId", shipperId)
                .list();
        transaction.commit();
        session.close();
        return orders;
    }

}
