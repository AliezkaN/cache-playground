-- Create table for PersonEntity
CREATE TABLE IF NOT EXISTS person_info (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        first_name VARCHAR(255),
        last_name VARCHAR(255),
        age INT,
        occupation VARCHAR(255),
        address VARCHAR(255),
        phone_number VARCHAR(20),
        email VARCHAR(255),
        social_security_number VARCHAR(20),
        favorite_color VARCHAR(50),
        blood_type VARCHAR(10),
        favorite_book VARCHAR(255),
        favorite_movie VARCHAR(255),
        zodiac_sign VARCHAR(50)
);
