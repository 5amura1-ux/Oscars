package com.example.controller;

import com.example.model.Customer;
import com.example.model.Vehicle;
import com.example.service.CustomerService;
import com.example.service.VehicleService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // Customer UI elements
    @FXML private TextField customerNameField;
    @FXML private TextField customerEmailField;
    @FXML private TextField customerPhoneField;
    @FXML private Button addCustomerBtn;
    @FXML private TableView<Customer> customerTableView;
    @FXML private TableColumn<Customer, Long> customerIdColumn;
    @FXML private TableColumn<Customer, String> customerNameColumn;
    @FXML private TableColumn<Customer, String> customerEmailColumn;
    @FXML private TableColumn<Customer, String> customerPhoneColumn;
    
    // Vehicle UI elements
    @FXML private TextField vehicleMakeField;
    @FXML private TextField vehicleModelField;
    @FXML private TextField vehicleYearField;
    @FXML private TextField vehicleLicenseField;
    @FXML private TextField vehicleCustomerIdField;
    @FXML private Button addVehicleBtn;
    @FXML private TableView<Vehicle> vehicleTableView;
    @FXML private TableColumn<Vehicle, Long> vehicleIdColumn;
    @FXML private TableColumn<Vehicle, String> vehicleMakeColumn;
    @FXML private TableColumn<Vehicle, String> vehicleModelColumn;
    @FXML private TableColumn<Vehicle, Integer> vehicleYearColumn;
    @FXML private TableColumn<Vehicle, String> vehicleLicenseColumn;
    @FXML private TableColumn<Vehicle, Long> vehicleOwnerColumn;
    
    // Services
    private CustomerService customerService;
    private VehicleService vehicleService;
    
    // Observable lists for TableViews
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();
    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize services
        customerService = new CustomerService();
        vehicleService = new VehicleService();
        
        // Initialize customer table columns
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        // Initialize vehicle table columns
        vehicleIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        vehicleMakeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        vehicleModelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        vehicleYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        vehicleLicenseColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        vehicleOwnerColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        
        // Load data
        loadCustomers();
        loadVehicles();
    }
    
    @FXML
    private void handleAddCustomer(ActionEvent event) {
        try {
            String name = customerNameField.getText();
            String email = customerEmailField.getText();
            String phone = customerPhoneField.getText();
            
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                showAlert("Validation Error", "Please fill all customer fields");
                return;
            }
            
            Customer customer = new Customer();
            customer.setFullName(name);
            customer.setEmail(email);
            customer.setPhone(phone);
            
            customerService.saveCustomer(customer);
            clearCustomerFields();
            loadCustomers();
            showAlert("Success", "Customer added successfully");
        } catch (Exception e) {
            showAlert("Error", "Failed to add customer: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleAddVehicle(ActionEvent event) {
        try {
            String make = vehicleMakeField.getText();
            String model = vehicleModelField.getText();
            String yearStr = vehicleYearField.getText();
            String license = vehicleLicenseField.getText();
            String customerIdStr = vehicleCustomerIdField.getText();
            
            if (make.isEmpty() || model.isEmpty() || yearStr.isEmpty() || license.isEmpty() || customerIdStr.isEmpty()) {
                showAlert("Validation Error", "Please fill all vehicle fields");
                return;
            }
            
            Integer year = Integer.parseInt(yearStr);
            Long customerId = Long.parseLong(customerIdStr);
            
            Vehicle vehicle = new Vehicle();
            vehicle.setMake(make);
            vehicle.setModel(model);
            vehicle.setYear(year);
            vehicle.setLicensePlate(license);
            vehicle.setCustomerId(customerId);
            
            vehicleService.saveVehicle(vehicle);
            clearVehicleFields();
            loadVehicles();
            showAlert("Success", "Vehicle added successfully");
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Year and Customer ID must be numbers");
        } catch (Exception e) {
            showAlert("Error", "Failed to add vehicle: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void loadCustomers() {
        try {
            customerList.clear();
            customerList.addAll(customerService.getAllCustomers());
            customerTableView.setItems(customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadVehicles() {
        try {
            vehicleList.clear();
            vehicleList.addAll(vehicleService.getAllVehicles());
            vehicleTableView.setItems(vehicleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void clearCustomerFields() {
        customerNameField.clear();
        customerEmailField.clear();
        customerPhoneField.clear();
    }
    
    private void clearVehicleFields() {
        vehicleMakeField.clear();
        vehicleModelField.clear();
        vehicleYearField.clear();
        vehicleLicenseField.clear();
        vehicleCustomerIdField.clear();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        // Kept for backward compatibility - this method is no longer used
    }
}
