package com.example.repository;

import com.example.model.Mechanic;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MechanicRepository {
    private final EntityRepository<Mechanic> entityRepository;
    
    public MechanicRepository() {
        this.entityRepository = new EntityRepository<>(Mechanic.class);
    }
    
    public void save(Mechanic mechanic) {
        entityRepository.save(mechanic);
    }
    
    public void update(Mechanic mechanic) {
        entityRepository.update(mechanic);
    }
    
    public void delete(Mechanic mechanic) {
        entityRepository.delete(mechanic);
    }
    
    public Mechanic findById(Long id) {
        return entityRepository.findById(id);
    }
    
    public List<Mechanic> findAll() {
        return entityRepository.findAll();
    }
    
    public List<Mechanic> findBySpecialization(String specialization) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Mechanic where specialization = :specialization";
            return session.createQuery(query, Mechanic.class)
                    .setParameter("specialization", specialization)
                    .list();
        }
    }
}
