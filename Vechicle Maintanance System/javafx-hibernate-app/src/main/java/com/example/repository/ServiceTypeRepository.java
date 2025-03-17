package com.example.repository;

import com.example.model.ServiceType;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ServiceTypeRepository {
    private final EntityRepository<ServiceType> entityRepository;
    
    public ServiceTypeRepository() {
        this.entityRepository = new EntityRepository<>(ServiceType.class);
    }
    
    public void save(ServiceType serviceType) {
        entityRepository.save(serviceType);
    }
    
    public void update(ServiceType serviceType) {
        entityRepository.update(serviceType);
    }
    
    public void delete(ServiceType serviceType) {
        entityRepository.delete(serviceType);
    }
    
    public ServiceType findById(Long id) {
        return entityRepository.findById(id);
    }
    
    public List<ServiceType> findAll() {
        return entityRepository.findAll();
    }
    
    public List<ServiceType> findByPriceRange(double minPrice, double maxPrice) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from ServiceType where price between :minPrice and :maxPrice order by price";
            return session.createQuery(query, ServiceType.class)
                    .setParameter("minPrice", minPrice)
                    .setParameter("maxPrice", maxPrice)
                    .list();
        }
    }
    
    public ServiceType findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from ServiceType where serviceName = :name";
            return session.createQuery(query, ServiceType.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }
}
