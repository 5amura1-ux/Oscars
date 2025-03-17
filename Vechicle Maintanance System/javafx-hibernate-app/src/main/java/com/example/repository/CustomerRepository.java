package com.example.repository;

import com.example.model.Customer;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {
    private final EntityRepository<Customer> entityRepository;
    
    public CustomerRepository() {
        this.entityRepository = new EntityRepository<>(Customer.class);
    }
    
    public void save(Customer customer) {
        entityRepository.save(customer);
    }
    
    public void update(Customer customer) {
        entityRepository.update(customer);
    }
    
    public void delete(Customer customer) {
        entityRepository.delete(customer);
    }
    
    public Customer findById(Long id) {
        return entityRepository.findById(id);
    }
    
    public List<Customer> findAll() {
        return entityRepository.findAll();
    }
    
    public Customer findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Customer where email = :email";
            return session.createQuery(query, Customer.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
    
    public List<Customer> findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Customer where fullName like :name";
            return session.createQuery(query, Customer.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
        }
    }
}
