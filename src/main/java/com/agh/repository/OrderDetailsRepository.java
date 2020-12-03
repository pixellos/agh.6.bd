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

    public List<OrderDetails> getByOrderId(Short orderId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o where o.orderDetailsId.orders.orderId=:orderId", OrderDetails.class)
                .setParameter("orderId", orderId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByProductId(Short orderId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o where o.orderDetailsId.products.productId=:orderId", OrderDetails.class)
                .setParameter("orderId", orderId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByProductCategory(String categoryName) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o where o.orderDetailsId.products.categories.categoryName=:categoryName", OrderDetails.class)
                .setParameter("categoryName", categoryName)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getBySupplierId(Short supplierId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o where o.orderDetailsId.products.suppliers.supplierId=:supplierId", OrderDetails.class)
                .setParameter("supplierId", supplierId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

}
