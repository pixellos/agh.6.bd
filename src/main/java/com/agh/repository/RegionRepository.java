package com.agh.repository;

import com.agh.model.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionRepository extends AbstractRepository {

    public List<Region> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Region> regions = session.createQuery("SELECT r FROM Region r", Region.class).list();
        transaction.commit();
        session.close();
        return regions;
    }
}
