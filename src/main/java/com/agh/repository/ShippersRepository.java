package com.agh.repository;

import com.agh.model.Shippers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShippersRepository extends AbstractRepository {

    public List<Shippers> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Shippers> shippers = session
                .createQuery("SELECT s FROM Shippers s", Shippers.class)
                .list();
        transaction.commit();
        session.close();
        return shippers;
    }

    public Optional<Shippers> getById(Short shipperId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<Shippers> shippers = session
                .createQuery("SELECT s FROM Shippers s WHERE s.shipperId=:shipperId", Shippers.class)
                .setParameter("shipperId", shipperId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return shippers;
    }
}
