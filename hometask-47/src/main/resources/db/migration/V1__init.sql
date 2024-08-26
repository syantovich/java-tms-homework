create table persons (
    id uuid primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,

    constraint name_uniq unique (email)
);

create table authorities (
    id uuid primary key,
    name varchar(255),
    person_id uuid,
    constraint person_id_fk foreign key (person_id) references persons (id) on DELETE cascade
);
