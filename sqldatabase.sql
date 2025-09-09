-- Drop and create database
DROP DATABASE IF EXISTS car_directory;
CREATE DATABASE IF NOT EXISTS car_directory;
USE car_directory;

-- 1️⃣ Create User table
CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

-- 2️⃣ Create Vehicle table
CREATE TABLE IF NOT EXISTS Vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL,
    model VARCHAR(50),
    year INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- 3️⃣ Create Appointment table
CREATE TABLE IF NOT EXISTS Appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    description VARCHAR(255) NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    vehicle_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id) ON DELETE CASCADE
);