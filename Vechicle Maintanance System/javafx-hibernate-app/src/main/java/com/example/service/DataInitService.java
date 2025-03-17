package com.example.service;

import com.example.model.Customer;
import com.example.model.Mechanic;
import com.example.model.Role;
import com.example.model.ServiceType;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.repository.CustomerRepository;
import com.example.repository.MechanicRepository;
import com.example.repository.RoleRepository;
import com.example.repository.ServiceTypeRepository;
import com.example.repository.UserRepository;
import com.example.repository.VehicleRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Service to initialize sample data for the application.
 */
public class DataInitService {
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final MechanicRepository mechanicRepository;
    private final ServiceTypeRepository serviceTypeRepository;
    
    public DataInitService() {
        this.customerRepository = new CustomerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.roleRepository = new RoleRepository();
        this.userRepository = new UserRepository();
        this.mechanicRepository = new MechanicRepository();
        this.serviceTypeRepository = new ServiceTypeRepository();
    }
    
    /**
     * Initialize sample data if the database is empty.
     */
    public void initData() {
        // Only initialize if no data exists
        if (customerRepository.findAll().isEmpty()) {
            initRoles();
            initUsers();
            initCustomersAndVehicles();
            initMechanics();
            initServiceTypes();
            System.out.println("Sample data initialized successfully");
        } else {
            System.out.println("Database already contains data, skipping initialization");
        }
    }
    
    private void initRoles() {
        // Check if roles already exist before creating new ones
        if (!roleRepository.findAll().isEmpty()) {
            System.out.println("Roles already exist, skipping role initialization");
            return;
        }
        
        List<Role> roles = Arrays.asList(
            createRole("ADMIN", "System Administrator"),
            createRole("MANAGER", "Shop Manager"),
            createRole("MECHANIC", "Mechanic"),
            createRole("RECEPTIONIST", "Front Desk Staff")
        );
        
        for (Role role : roles) {
            roleRepository.save(role);
        }
    }
    
    private Role createRole(String name, String description) {
        Role role = new Role();
        role.setRoleName(name);
        role.setDescription(description);
        return role;
    }
    
    private void initUsers() {
        // Find role IDs
        Role adminRole = roleRepository.findByRoleName("ADMIN");
        Role managerRole = roleRepository.findByRoleName("MANAGER");
        
        if (adminRole != null && managerRole != null) {
            User admin = new User();
            admin.setFullName("System Admin");
            admin.setEmail("admin@vehicle-maint.com");
            admin.setPassword("admin123"); // In real app, would be hashed
            admin.setRoleId(adminRole.getRoleId());
            userRepository.save(admin);
            
            User manager = new User();
            manager.setFullName("Shop Manager");
            manager.setEmail("manager@vehicle-maint.com");
            manager.setPassword("manager123"); // In real app, would be hashed
            manager.setRoleId(managerRole.getRoleId());
            userRepository.save(manager);
        }
    }
    
    private void initCustomersAndVehicles() {
        // Create some customers
        Customer customer1 = createCustomer("John Doe", "john@example.com", "555-123-4567", "123 Main St");
        Customer customer2 = createCustomer("Jane Smith", "jane@example.com", "555-765-4321", "456 Oak Ave");
        Customer customer3 = createCustomer("Bob Johnson", "bob@example.com", "555-987-6543", "789 Pine Rd");
        
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        
        // Create vehicles for each customer
        Vehicle vehicle1 = createVehicle("Toyota", "Camry", 2019, "ABC123", customer1.getCustomerId());
        Vehicle vehicle2 = createVehicle("Honda", "Accord", 2020, "XYZ789", customer1.getCustomerId());
        Vehicle vehicle3 = createVehicle("Ford", "Focus", 2018, "DEF456", customer2.getCustomerId());
        Vehicle vehicle4 = createVehicle("Chevrolet", "Malibu", 2021, "GHI789", customer3.getCustomerId());
        
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);
        vehicleRepository.save(vehicle4);
    }
    
    private Customer createCustomer(String name, String email, String phone, String address) {
        Customer customer = new Customer();
        customer.setFullName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        return customer;
    }
    
    private Vehicle createVehicle(String make, String model, int year, String licensePlate, Long customerId) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setYear(year);
        vehicle.setLicensePlate(licensePlate);
        vehicle.setCustomerId(customerId);
        return vehicle;
    }
    
    private void initMechanics() {
        List<Mechanic> mechanics = Arrays.asList(
            createMechanic("Mike Smith", "Engine Specialist"),
            createMechanic("Sarah Johnson", "Electrical Systems"),
            createMechanic("David Brown", "General Repair")
        );
        
        for (Mechanic mechanic : mechanics) {
            mechanicRepository.save(mechanic);
        }
    }
    
    private Mechanic createMechanic(String name, String specialization) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFullName(name);
        mechanic.setSpecialization(specialization);
        return mechanic;
    }
    
    private void initServiceTypes() {
        List<ServiceType> serviceTypes = Arrays.asList(
            createServiceType("Oil Change", 49.99, 30),
            createServiceType("Tire Rotation", 29.99, 20),
            createServiceType("Brake Inspection", 89.99, 45),
            createServiceType("Engine Tune-up", 199.99, 120),
            createServiceType("AC Service", 149.99, 60)
        );
        
        for (ServiceType serviceType : serviceTypes) {
            serviceTypeRepository.save(serviceType);
        }
    }
    
    private ServiceType createServiceType(String name, double price, int duration) {
        ServiceType serviceType = new ServiceType();
        serviceType.setServiceName(name);
        serviceType.setPrice(price);
        serviceType.setDuration(duration);
        return serviceType;
    }
}
