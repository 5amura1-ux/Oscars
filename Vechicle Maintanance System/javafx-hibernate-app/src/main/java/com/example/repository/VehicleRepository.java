package com.example.repository;

import com.example.model.Vehicle;
import com.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleRepository {
    private final EntityRepository<Vehicle> entityRepository;

    public VehicleRepository() {
        this.entityRepository = new EntityRepository<>(Vehicle.class);
    }

    public void save(Vehicle vehicle) {
        entityRepository.save(vehicle);
    }

    public void update(Vehicle vehicle) {
        entityRepository.update(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityRepository.delete(vehicle);
    }

    public Vehicle findById(Long id) {
        return entityRepository.findById(id);
    }

    public List<Vehicle> findAll() {
        return entityRepository.findAll();
    }

    public List<Vehicle> findByCustomerId(Long customerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Vehicle where customerId = :customerId", Vehicle.class)
                    .setParameter("customerId", customerId)
                    .list();
        }
    }

    public List<Vehicle> findByMakeAndModel(String make, String model) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Vehicle where make = :make and model = :model", Vehicle.class)
                    .setParameter("make", make)
                    .setParameter("model", model)
                    .list();
        }
    }
}
