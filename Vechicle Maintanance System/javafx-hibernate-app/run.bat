@echo off
java --module-path "C:\Program Files\Eclipse Adoptium\jdk-21.0.6.7-hotspot\jmods" --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar target/javafx-hibernate-app-1.0-SNAPSHOT-jar-with-dependencies.jar
