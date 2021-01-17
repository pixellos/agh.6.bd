package com.agh.repository;

import com.agh.model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository extends AbstractRepository {

    public List<Products> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Products> products = session
                .createQuery("SELECT p FROM Products p" +
                        " INNER JOIN FETCH p.suppliers s" +
                        " INNER JOIN FETCH p.categories c", Products.class)
                .list();
        transaction.commit();
        session.close();
        return products;
    }

    public Optional<Products> getById(Short productId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<Products> product = session
                .createQuery("SELECT p FROM Products p WHERE p.productId=:productId", Products.class)
                .setParameter("productId", productId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return product;
    }

    public List<Products> getAllByCategory(String categoryName) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();

        List<Products> products = session.createQuery(
                "SELECT p FROM Products p" +
                        " INNER JOIN FETCH p.suppliers s" +
                        " INNER JOIN FETCH p.categories c" +
                        " WHERE c.categoryName=:categoryName", Products.class)
                .setParameter("categoryName", categoryName)
                .list();

        transaction.commit();
        session.close();
        return products;
    }

    public List<Products> getAllBySupplierId(Short supplierId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();

        List<Products> products = session.createQuery(
                "SELECT p FROM Products p" +
                        " INNER JOIN FETCH p.suppliers s" +
                        " INNER JOIN FETCH p.categories c" +
                        " WHERE s.supplierId=:supplierId", Products.class)
                .setParameter("supplierId", supplierId)
                .list();

        transaction.commit();
        session.close();
        return products;
    }

    public List<Products> getAllBySuppliersCountry(String suppliersCountry) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();

        List<Products> products = session.createQuery(
                "SELECT p FROM Products p" +
                        " INNER JOIN FETCH p.suppliers s " +
                        " INNER JOIN FETCH p.categories c" +
                        " WHERE s.country=:suppliersCountry", Products.class)
                .setParameter("suppliersCountry", suppliersCountry)
                .list();

        transaction.commit();
        session.close();
        return products;
    }

    public void persist(Products product) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
    }
}
