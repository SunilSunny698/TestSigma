Set FOREIGN_KEY_CHECKS = 0;
drop table if EXISTS Customer,Orders;

Set FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE Orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    payment BOOLEAN NOT NULL,
    status ENUM('PENDING','DELIVERED','RETURN') NOT NULL,
    foreign KEY (customer_id) REFERENCES Customer(id)
);