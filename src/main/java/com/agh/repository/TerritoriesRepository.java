package com.agh.repository;

import com.agh.model.Territories;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TerritoriesRepository extends AbstractRepository {
    public List<Territories> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Territories> territories = session
                .createQuery("SELECT t FROM Territories t", Territories.class)
                .list();
        transaction.commit();
        session.close();
        return territories;

    }
}
