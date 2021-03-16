create schema tema10siit;
use
tema10siit;

create table if not exists cars
(
    id   int auto_increment primary key,
    Car_Model varchar(50) not null,
    Car_Colour varchar(50) not null,
    Horse_Power int

    );

INSERT INTO cars
VALUES (1, 'B.M.W E63', 'RED', 280),
       (2, 'MERCEDES S63 AMG', 'BLACK', 467),
       (3, 'DAGIA LOGAN', 'PINK', 75),
       (4, 'PEUGEOT 406', 'BLUE', 135),
       (5, 'TRABANT', 'WHITE', 35);
