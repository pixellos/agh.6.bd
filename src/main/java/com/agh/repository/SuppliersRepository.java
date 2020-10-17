package com.agh.repository;

import com.agh.model.Suppliers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuppliersRepository extends AbstractRepository {

    public List<Suppliers> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Suppliers> suppliers = session
                .createQuery("SELECT s FROM Suppliers s", Suppliers.class)
                .list();
        transaction.commit();
        session.close();
        return suppliers;
    }
}
