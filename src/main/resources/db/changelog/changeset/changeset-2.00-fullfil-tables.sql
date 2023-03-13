--liquibase formatted sql

--changeset gznznzjsn:fulfill-roles
insert into roles (value)
values ('USER'),
       ('EMPLOYEE_MANAGER');
