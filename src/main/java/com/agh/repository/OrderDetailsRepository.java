package com.agh.repository;

import com.agh.model.OrderDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsRepository extends AbstractRepository {

    public List<OrderDetails> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o", OrderDetails.class)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }
}
