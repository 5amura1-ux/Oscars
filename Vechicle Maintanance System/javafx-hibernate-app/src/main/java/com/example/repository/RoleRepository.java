package com.example.repository;

import com.example.model.Role;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class RoleRepository {
    private final EntityRepository<Role> entityRepository;
    
    public RoleRepository() {
        this.entityRepository = new EntityRepository<>(Role.class);
    }
    
    public void save(Role role) {
        entityRepository.save(role);
    }
    
    public void update(Role role) {
        entityRepository.update(role);
    }
    
    public void delete(Role role) {
        entityRepository.delete(role);
    }
    
    public Role findById(Long id) {
        return entityRepository.findById(id);
    }
    
    public List<Role> findAll() {
        return entityRepository.findAll();
    }
    
    public Role findByRoleName(String roleName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from Role where roleName = :roleName";
            List<Role> roles = session.createQuery(query, Role.class)
                    .setParameter("roleName", roleName)
                    .list();
            
            // Return the first role found or null if none exists
            return roles.isEmpty() ? null : roles.get(0);
        }
    }
}
