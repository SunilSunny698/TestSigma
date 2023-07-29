CREATE TABLE Product (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    total_quantity INT NOT NULL,
    created_at DATETIME NOT NULL,
);