CREATE TABLE Order (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATETIME NOT NULL,
    delivery_date DATETIME,
    status VARCHAR(20) NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(id)
);