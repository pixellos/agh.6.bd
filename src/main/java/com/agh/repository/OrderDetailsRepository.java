package com.agh.repository;

import com.agh.model.OrderDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDetailsRepository extends AbstractRepository {

    public List<OrderDetails> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s", OrderDetails.class)
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
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s" +
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
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s" +
                        " WHERE p.productId=:productId", OrderDetails.class)
                .setParameter("productId", productId)
                .list();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public Optional<OrderDetails> getByOrderIdAndProductId(Short productId, Short orderId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s" +
                        " WHERE p.productId=:productId AND ord.orderId=:orderId", OrderDetails.class)
                .setParameter("productId", productId)
                .setParameter("orderId", orderId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return orderDetails;
    }

    public List<OrderDetails> getByProductCategory(String categoryName) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<OrderDetails> orderDetails = session
                .createQuery("SELECT o FROM OrderDetails o" +
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s" +
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
                        " INNER JOIN FETCH o.orderDetailsId.orders ord" +
                        " INNER JOIN FETCH ord.customers c" +
                        " INNER JOIN FETCH ord.employees e" +
                        " INNER JOIN FETCH ord.shippers sh " +
                        " INNER JOIN FETCH o.orderDetailsId.products p" +
                        " INNER JOIN FETCH p.categories cat" +
                        " INNER JOIN FETCH p.suppliers s" +
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

    public void delete(OrderDetails orderDetails) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orderDetails);
        transaction.commit();
        session.close();
    }

}
