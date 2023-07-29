CREATE TABLE Class_Student (
    class_id INT,
    Student_id INT,
    PRIMARY KEY (Class_id, Student_id),
    FOREIGN KEY (Class_id) REFERENCES Class (id),
    FOREIGN KEY (Student_id) REFERENCES Student (id)
);