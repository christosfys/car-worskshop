
drop database car_directory;
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
vehicle_id int,
foreign key(vehicle_id) references Vehicle(id) on delete Cascade );


SELECT 
    v.id AS vehicle_id,
    v.plate_number,
    v.model,
    v.year,
    u.id AS user_id,
    u.name AS user_name,
    u.phone AS user_phone
FROM Vehicle v
JOIN User u ON v.user_id = u.id
WHERE v.user_id = 1;