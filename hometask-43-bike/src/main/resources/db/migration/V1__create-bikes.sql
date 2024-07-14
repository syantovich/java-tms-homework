create table bikes(
    id uuid primary key,
    num int,
    brand varchar,
    type varchar,
    is_hidden boolean default false,
    is_booked boolean default false,

    version int
)