Set FOREIGN_KEY_CHECKS = 0;
drop table if EXISTS Student, Class,address,subject;

Set FOREIGN_KEY_CHECKS = 1;

CREATE TABLE address(
    id INT PRIMARY KEY,
    city VARCHAR(40)
);
create table Student(
    id int PRIMARY KEY ,
    name varchar(30) not null,
    address_id INT,
    Gender varchar(10) not null,
    age int not null,
    FOREIGN KEY(address_id) REFERENCES address(id) ON DELETE CASCADE
);
create table class(
    id int PRIMARY KEY ,
    name varchar(30) not null,
    capacity int not null,
    teacher varchar(30) not null
);


CREATE TABLE subject(
    id INT PRIMARY KEY,
    name VARCHAR(40),
    student_id INT,
    FOREIGN KEY(student_id) REFERENCES student(id) ON DELETE CASCADE
);

