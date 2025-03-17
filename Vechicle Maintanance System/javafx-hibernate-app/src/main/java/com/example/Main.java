package com.example;

import com.example.service.DataInitService;
import com.example.util.HibernateUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Initialize Hibernate - test connection
            HibernateUtil.getSessionFactory();
            
            // Initialize sample data
            DataInitService dataInitService = new DataInitService();
            dataInitService.initData();
            
            // Ensure DataInitService is correctly using repositories and models
            // Check DataInitService.java for correct repository and model usage
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Vehicle Maintenance System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAndExit("Failed to start application: " + e.getMessage());
        }
    }

    @Override
    public void stop() {
        // Properly close Hibernate resources
        try {
            HibernateUtil.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showErrorAndExit(String message) {
        System.err.println("ERROR: " + message);
        Platform.exit();
    }

    /**
     * Main entry point for the application.
     * To run this application:
     * 1. Using an IDE: Right-click on this file and select "Run Main.main()"
     * 2. Using Maven: Navigate to the project root and run "mvn clean package" followed by "mvn javafx:run"
     * 3. Using Java command: After building with Maven, run "java -jar target/javafx-hibernate-app.jar"
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
