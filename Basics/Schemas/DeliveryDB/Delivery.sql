CREATE TABLE Delivery (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    driver_id INT NOT NULL,
    delivery_date DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Order(id),
    FOREIGN KEY (driver_id) REFERENCES Driver(id)
);