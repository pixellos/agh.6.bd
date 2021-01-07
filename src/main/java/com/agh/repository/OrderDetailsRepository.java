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
                .createQuery("SELECT o FROM OrderDetails o" +
                        " LEFT JOIN FETCH o.orderDetailsId.orders ord" +
                        " LEFT JOIN FETCH ord.customers c" +
                        " LEFT JOIN FETCH ord.employees e" +
                        " LEFT JOIN FETCH ord.shippers sh " +
                        " LEFT JOIN FETCH o.orderDetailsId.products p" +
                        " LEFT JOIN FETCH p.categories cat" +
                        " LEFT JOIN FETCH p.suppliers s", OrderDetails.class)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByOrderId(Short orderId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " LEFT JOIN FETCH o.orderDetailsId.orders ord" +
                        " LEFT JOIN FETCH ord.customers c" +
                        " LEFT JOIN FETCH ord.employees e" +
                        " LEFT JOIN FETCH ord.shippers sh " +
                        " LEFT JOIN FETCH o.orderDetailsId.products p" +
                        " LEFT JOIN FETCH p.categories cat" +
                        " LEFT JOIN FETCH p.suppliers s" +
                        " WHERE ord.orderId=:orderId", OrderDetails.class)
                .setParameter("orderId", orderId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByProductId(Short productId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " LEFT JOIN FETCH o.orderDetailsId.orders ord" +
                        " LEFT JOIN FETCH ord.customers c" +
                        " LEFT JOIN FETCH ord.employees e" +
                        " LEFT JOIN FETCH ord.shippers sh " +
                        " LEFT JOIN FETCH o.orderDetailsId.products p" +
                        " LEFT JOIN FETCH p.categories cat" +
                        " LEFT JOIN FETCH p.suppliers s" +
                        " WHERE p.productId=:productId", OrderDetails.class)
                .setParameter("productId", productId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByProductCategory(String categoryName) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " LEFT JOIN FETCH o.orderDetailsId.orders ord" +
                        " LEFT JOIN FETCH ord.customers c" +
                        " LEFT JOIN FETCH ord.employees e" +
                        " LEFT JOIN FETCH ord.shippers sh " +
                        " LEFT JOIN FETCH o.orderDetailsId.products p" +
                        " LEFT JOIN FETCH p.categories cat" +
                        " LEFT JOIN FETCH p.suppliers s" +
                        " WHERE cat.categoryName =:categoryName", OrderDetails.class)
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
                .createQuery("SELECT o FROM OrderDetails o" +
                        " LEFT JOIN FETCH o.orderDetailsId.orders ord" +
                        " LEFT JOIN FETCH ord.customers c" +
                        " LEFT JOIN FETCH ord.employees e" +
                        " LEFT JOIN FETCH ord.shippers sh " +
                        " LEFT JOIN FETCH o.orderDetailsId.products p" +
                        " LEFT JOIN FETCH p.categories cat" +
                        " LEFT JOIN FETCH p.suppliers s" +
                        " WHERE s.supplierId=:supplierId", OrderDetails.class)
                .setParameter("supplierId", supplierId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public void persist(OrderDetails orderDetails) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.persist(orderDetails);
        transaction.commit();
        session.close();
    }

}
