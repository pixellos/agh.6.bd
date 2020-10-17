package com.agh.repository;

import com.agh.model.CustomerDemographics;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDemographicsRepository extends AbstractRepository {

    public List<CustomerDemographics> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<CustomerDemographics> customerDemographics = session
                .createQuery("SELECT c FROM CustomerDemographics c", CustomerDemographics.class)
                .list();
        transaction.commit();
        session.close();
        return customerDemographics;
    }
}
