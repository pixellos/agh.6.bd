package com.agh.repository;

import com.agh.model.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeesRepository extends AbstractRepository {

    public List<Employees> getAll() {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        List<Employees> employees = session.createQuery("SELECT e FROM Employees e", Employees.class).list();
        transaction.commit();
        session.close();
        return employees;
    }
}
