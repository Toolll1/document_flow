drop table if exists USERS cascade;

create table if not exists "USERS" (
    id int PRIMARY KEY,
    name varchar(100),
    email varchar(100),
    login varchar(100)
);