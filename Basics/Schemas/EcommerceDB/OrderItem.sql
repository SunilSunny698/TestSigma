CREATE TABLE OrderItems (
    id INT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Order(id),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);
