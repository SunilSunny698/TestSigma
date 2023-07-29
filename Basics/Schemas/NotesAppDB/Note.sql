CREATE TABLE Notes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(30) NOT NULL,
    Description VARCHAR(100),
    Userid INT,
    created_at DATETIME,
    FOREIGN KEY (Userid) REFERENCES Users(Userid)
);