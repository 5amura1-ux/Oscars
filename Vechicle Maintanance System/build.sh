#!/bin/bash
echo "Building Vehicle Maintenance System..."

cd javafx-hibernate-app
mvn clean package

echo
if [ $? -eq 0 ]; then
    echo "Build successful! JAR file created in target directory."
    echo "Run the application using run.sh"
else
    echo "Build failed. Check the error messages above."
fi
