DROP DATABASE IF EXISTS spring_mentoring;

CREATE DATABASE spring_mentoring;

USE spring_mentoring;

CREATE TABLE users
(
    id       bigint AUTO_INCREMENT NOT NULL,
    login    VARCHAR(20) UNIQUE    not null,
    password VARCHAR(100)          not null,
    role     enum ('ADMIN', 'USER'),
    status   enum ('ACTIVE', 'BANNED') default 'ACTIVE',
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE product
(
    id    bigint             NOT NULL AUTO_INCREMENT,
    name  VARCHAR(20) UNIQUE NOT NULL,
    price double             NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

insert into users
    (login, password, role, status)
values ('admin', '$2y$12$F8MEnNvYjISmU3PZfyPc8O9mKglNhL2beFKcxASz2wW1ru2/qoGzi', 'ADMIN', 'ACTIVE'),
       ('user', '$2y$12$94wi366PlbLoAW7IUeCY4uzU0zb7GpPfl0BJMGjmqIHgewlzNDe86', 'USER', 'ACTIVE');

insert into product
    (name, price)
values ('Jacket', 50),
       ('Shirt', 20),
       ('T-shirt', 30),
       ('Pullover', 60);