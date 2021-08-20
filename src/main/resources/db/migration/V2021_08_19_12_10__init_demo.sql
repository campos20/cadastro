use f1_manager;

create table driver(
    id int primary key auto_increment,
    name varchar(40),
    num int,
    country varchar(30),
    team varchar(20)
);

create table team(
    id int primary key auto_increment,
    team varchar(30)
);