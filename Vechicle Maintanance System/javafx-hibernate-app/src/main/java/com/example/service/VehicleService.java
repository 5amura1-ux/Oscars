package com.example.service;

import com.example.model.Vehicle;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleService {

    public void saveVehicle(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Vehicle", Vehicle.class).list();
        }
    }

    public List<Vehicle> getVehiclesByCustomer(Long customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Vehicle where customerId = :customerId", Vehicle.class)
                    .setParameter("customerId", customerId)
                    .list();
        }
    }
}
