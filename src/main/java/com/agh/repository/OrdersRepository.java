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

}
