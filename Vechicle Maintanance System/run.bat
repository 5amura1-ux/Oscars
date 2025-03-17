@echo off
set JAVAFX_PATH=.\javafx-hibernate-app\lib
set MAIN_CLASS=com.example.Main

cd javafx-hibernate-app
mvn clean compile
mvn javafx:run

pause
