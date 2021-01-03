package com.agh.repository;

import com.agh.model.Categories;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Categories> getById(Short categoryId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<Categories> category = session
                .createQuery("SELECT c FROM Categories c WHERE c.categoryId =: categoryId", Categories.class)
                .setParameter("categoryId", categoryId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return category;
    }
}
