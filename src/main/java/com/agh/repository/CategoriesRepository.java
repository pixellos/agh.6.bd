package com.agh.repository;

import com.agh.model.Categories;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesRepository extends AbstractRepository {

    public List<Categories> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Categories> categories = session.createQuery("SELECT c FROM Categories c", Categories.class).list();
        transaction.commit();
        session.close();
        return categories;
    }
}
