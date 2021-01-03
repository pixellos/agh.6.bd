package com.agh.repository;

import com.agh.model.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Employees> getById(Short employeeId) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        Optional<Employees> employees = session.createQuery("SELECT e FROM Employees e WHERE e.employeeId=:employeeId", Employees.class)
                .setParameter("employeeId", employeeId)
                .uniqueResultOptional();
        transaction.commit();
        session.close();
        return employees;
    }
}
