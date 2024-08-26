CREATE DATABASE ATSDB;
USE ATSDB;

CREATE TABLE users(login_id VARCHAR(255) PRIMARY KEY,
                   email VARCHAR(255) NOT NULL UNIQUE,
                   password VARCHAR(255) NOT NULL,
                   no_of_attempts_left INT DEFAULT 0,
                   is_account_disabled BOOLEAN DEFAULT FALSE,
                   lock_time DATETIME DEFAULT NULL);
SELECT * FROM users;


CREATE TABLE planes(plane_id VARCHAR(255) PRIMARY KEY,
                    plane_capacity INT NOT NULL,
                    plane_category VARCHAR(255) NOT NULL,
                    plane_model VARCHAR(255) NOT NULL,
                    plane_operator VARCHAR(255) NOT NULL);
                
SELECT * FROM planes;
update planes set plane_id = "P0001";
DROP Table planes;

CREATE Table airports(airport_id VARCHAR(255) PRIMARY KEY,
                      airport_name VARCHAR(255) NOT NULL,
                      country_code VARCHAR(255) NOT NULL);
SELECT * from airports;

select max(airport_id) from airports;

UPDATE airports set airport_id = "A0003";


CREATE Table bookings(booking_id VARCHAR(255) PRIMARY KEY,
                      passenger_name VARCHAR(255) NOT NULL,
                      booking_date DATE NOT NULL,
                      seat_number VARCHAR(255) NOT NULL,
                      cost DOUBLE NOT NULL,
                      total_amount DOUBLE NOT NULL,
                      departure_date_time DATETIME NOT NULL,
                      arrival_date_time DATETIME NOT NULL);
SELECT * FROM bookings;                      