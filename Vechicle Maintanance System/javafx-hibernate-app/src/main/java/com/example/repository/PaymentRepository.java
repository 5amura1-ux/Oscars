package com.example.repository;

import com.example.model.Payment;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class PaymentRepository {
    private final EntityRepository<Payment> entityRepository;
    
    public PaymentRepository() {
        this.entityRepository = new EntityRepository<>(Payment.class);
    }
    
    public void save(Payment payment) {
        entityRepository.save(payment);
    }
    
    public void update(Payment payment) {
        entityRepository.update(payment);
    }
    
    public void delete(Payment payment) {
        entityRepository.delete(payment);
    }
    
    public Payment findById(Long id) {
        return entityRepository.findById(id);
    }
    
    public List<Payment> findAll() {
        return entityRepository.findAll();
    }
    
    public List<Payment> findByInvoiceId(Long invoiceId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Payment where invoiceId = :invoiceId";
            return session.createQuery(query, Payment.class)
                    .setParameter("invoiceId", invoiceId)
                    .list();
        }
    }
    
    public List<Payment> findByDateRange(Date startDate, Date endDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Payment where paymentDate between :startDate and :endDate";
            return session.createQuery(query, Payment.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .list();
        }
    }
}
