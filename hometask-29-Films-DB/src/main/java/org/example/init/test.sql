create table if not exists films (
    id uuid primary key,
    name varchar,
    description text,
    year int,
    is_viewed boolean
);