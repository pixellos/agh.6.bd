package com.agh.repository;

import com.agh.model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository extends AbstractRepository {

    public List<Products> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Products> products = session.createQuery("SELECT p FROM Products p", Products.class).list();
        transaction.commit();
        session.close();
        return products;
    }
}
