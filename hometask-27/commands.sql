create database tms_db;



-- Таблица - заказы
-- 	первичный ключ
-- 	название заказа (строковой тип)
-- 	дата заказа
-- 	количество товаров
-- 	стоимость заказа
-- 	нужна ли доставка (bool)

create table orders (
    id serial primary key,
    name varchar,
    order_date date,
    count int,
    total_price real,
    need_deliver boolean
);

alter table orders alter column total_price type double precision;

insert into orders (name, order_date, count, total_price, need_deliver)
values ('111','12-11-2010',3,4.55,false),
       ('dsfdsd','14-12-2022',1000,12313.65,true);

truncate table orders;