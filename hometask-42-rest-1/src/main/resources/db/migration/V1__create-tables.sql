drop type sex;
create type sex as ENUM ('MAN','WOMAN');

create table students (
    id uuid DEFAULT gen_random_uuid() primary key,
    first_name varchar(255),
    last_name varchar(255),
    sex sex not null,
    birthday date not null,
    class_num integer not null,
    home_address text
)