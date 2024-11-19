CREATE TABLE rating_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    standard_percentage DECIMAL(5, 2) NOT NULL
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    rating VARCHAR(255) NOT NULL
);
