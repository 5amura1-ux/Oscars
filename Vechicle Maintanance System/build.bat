@echo off
echo Building Vehicle Maintenance System...

cd javafx-hibernate-app
call mvn clean package

echo.
if %errorlevel% equ 0 (
    echo Build successful! JAR file created in target directory.
    echo Run the application using run.bat
) else (
    echo Build failed. Check the error messages above.
)

pause
