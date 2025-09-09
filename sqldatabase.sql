CREATE DATABASE IF NOT EXISTS car_directory;
USE car_directory;

-- 2️⃣ Create User table
CREATE TABLE IF NOT EXISTS User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

-- 3️⃣ Create Vehicle table
CREATE TABLE IF NOT EXISTS Vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    plate_number VARCHAR(20) NOT NULL,
   
    model VARCHAR(50),
    year INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);


create table if not exists Appoitment(
id int auto_increment PRIMARY KEY,
date date not null,
description varchar(20) not null,
cost int not null,
vehicle_int int,
foreign key(vehicle_int) references Vehicle(id) on delete Cascade );
ALTER TABLE Appoitment
MODIFY description varchar(100) not null;
INSERT INTO Appoitment (date, description, cost)
VALUES ('2025-06-12', 'oil-changes', 10);
select * from Appoitment;