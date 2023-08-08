INSERT INTO Customer (name, email, phone) VALUES
    ('Sunil', 'sunil@gmail.com', '1234567890'),
    ('SIva', 'siva@gmail.com', '9876543210'),
    ('Tony', 'tony@gmail.com', '5555555555'),
    ('Bruce', 'bruce@gmail.com', '7777777777'),
    ('Thor', 'thor@gmail.com', '9999999999');

INSERT INTO Orders (customer_id, payment, status) VALUES
    (1, true, 'RETURN'),
    (1, false, 'PENDING'),
    (2, true, 'DELIVERED'),
    (2, true, 'RETURN'),
    (3, false, 'RETURN'),
    (3, true, 'DELIVERED'),
    (4, false, 'PENDING'),
    (4, true, 'RETURN'),
    (5, true, 'DELIVERED'),
    (5, true, 'RETURN');


{
    "id": 1,
    "name": "Sunil",
    "email": "sunil@gmail.com",
    "phone": "1234567890"
}
{
    "id": 2,
    "name": "Siva",
    "email": "siva@gmail.com",
    "phone": "9876543210"
}
{
    "id": 3,
    "name": "Tony",
    "email": "tony@gmail.com",
    "phone": "5555555555"
}
{
    "id": 4,
    "name": "Bruce",
    "email": "bruce@gmail.com",
    "phone": "7777777777"
}
{
    "id": 5,
    "name": "Thor",
    "email": "thor@gmail.com",
    "phone": "9999999999"
}


