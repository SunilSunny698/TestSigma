Set FOREIGN_KEY_CHECKS = 0;
drop table if EXISTS User;

Set FOREIGN_KEY_CHECKS = 1;
Create table User(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20),
    email varchar(30)
);