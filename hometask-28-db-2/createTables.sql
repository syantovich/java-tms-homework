create table if not exists sexes (
    id serial primary key ,
    name varchar
);

create table if not exists persons (
    id int primary key,
    name varchar,
    birthday_date date,
    sex_id int not null,
    constraint sex_fk foreign key (sex_id) references sexes (id)
);

create table if not exists hobbies_types (
    id serial primary key,
    name varchar
);

create table if not exists hobbies (
    id serial primary key,
    name varchar,
    type_id int,
    constraint type_id_fk foreign key (type_id) references hobbies_types (id) on DELETE cascade
);

create table if not exists person_hobbies (
    id serial primary key,
    person_id int,
    hobby_id int,
    constraint person_fk foreign key (person_id) references persons (id) on delete cascade,
    constraint hobby_fk foreign key (hobby_id) references hobbies (id) on delete cascade
);


