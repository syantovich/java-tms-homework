create table products_39
(
    uuid        uuid             not null
        primary key,
    description varchar(255)     not null,
    name        varchar(255)     not null,
    price       double precision not null,
    status      varchar(255)     not null,
    updated     timestamp(6),
    created     timestamp(6),
    version     integer
);