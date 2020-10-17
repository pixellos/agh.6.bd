package com.agh.repository;

import com.agh.model.Customers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersRepository extends AbstractRepository {

    public List<Customers> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Customers> customers = session
                .createQuery("SELECT c FROM Customers c", Customers.class)
                .list();
        transaction.commit();
        session.close();
        return customers;
    }

}
