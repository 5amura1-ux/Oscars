package com.example;

import com.example.model.Customer;
import com.example.model.Vehicle;
import com.example.repository.CustomerRepository;
import com.example.repository.VehicleRepository;
import com.example.util.HibernateUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    
    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;
    
    @Before
    public void setUp() {
        customerRepository = new CustomerRepository();
        vehicleRepository = new VehicleRepository();
    }
    
    @After
    public void tearDown() {
        // Close Hibernate SessionFactory after tests
        HibernateUtil.shutdown();
    }
    
    @Test
    public void testCustomerCreation() {
        // Create a test customer
        Customer customer = new Customer();
        customer.setFullName("Test Customer");
        customer.setEmail("test@example.com");
        customer.setPhone("123-456-7890");
        customer.setAddress("123 Test Street");
        
        // Save the customer
        customerRepository.save(customer);
        
        // Check that customer has an ID (was saved)
        Assert.assertNotNull(customer.getCustomerId());
        
        // Clean up - delete the test customer
        customerRepository.delete(customer);
    }
    
    @Test
    public void testVehicleCreation() {
        // First create a customer
        Customer customer = new Customer();
        customer.setFullName("Vehicle Owner");
        customer.setEmail("owner@example.com");
        customer.setPhone("987-654-3210");
        
        customerRepository.save(customer);
        
        // Now create a vehicle for this customer
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setYear(2020);
        vehicle.setLicensePlate("TEST123");
        vehicle.setCustomerId(customer.getCustomerId());
        
        vehicleRepository.save(vehicle);
        
        // Check that vehicle has an ID (was saved)
        Assert.assertNotNull(vehicle.getVehicleId());
        
        // Clean up - delete test data
        vehicleRepository.delete(vehicle);
        customerRepository.delete(customer);
    }
}
