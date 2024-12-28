--liquibase formatted sql

--changeset endoscope:1

CREATE TABLE IF NOT EXISTS directory (
    directory_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    directory_name VARCHAR(256) NOT NULL,
    directory_description VARCHAR(2048),
    parent_directory_id BIGINT,
    image_count int,
    directory_position int,
    FOREIGN KEY (parent_directory_id) REFERENCES directory(directory_id)
);

CREATE TABLE IF NOT EXISTS image (
    image_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    image_name VARCHAR(256) NOT NULL,
    directory_id BIGINT,
    uploaded_by VARCHAR(256),
    upload_date TIMESTAMP,
    description VARCHAR(2048),
    image_data LONGBLOB, -- Field to hold the image data
    FOREIGN KEY (directory_id) REFERENCES directory(directory_id)
);

CREATE TABLE IF NOT EXISTS user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    salutation VARCHAR(256) NOT NULL,
    gender VARCHAR(256) NOT NULL,
    full_name VARCHAR(256) NOT NULL,
    age VARCHAR(256) NOT NULL,
    date_of_birth DATE NOT NULL,
    country_of_origin VARCHAR(256) NOT NULL,
    work_location VARCHAR(256) NOT NULL,
    work_place_setting VARCHAR(256) NOT NULL,
    medical_id VARCHAR(256),
    medical_speciality VARCHAR(256) NOT NULL,
    education VARCHAR(256) NOT NULL,
    role VARCHAR(256) NOT NULL
);

-- changeset endoscope:2
ALTER TABLE image
    ADD COLUMN state VARCHAR(16) NOT NULL DEFAULT 'PENDING';

