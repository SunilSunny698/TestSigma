CREATE TABLE  Class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    capacity INT,
    subject_id INT,
    teacher_id INT,
    FOREIGN KEY (subject_id) REFERENCES Subjects(id),
    FOREIGN KEY (teacher_id) REFERENCES Teacher(id)
);