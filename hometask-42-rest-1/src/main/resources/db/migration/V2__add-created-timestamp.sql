alter table students add column created timestamp default now();
alter table students add column updated timestamp default now();
alter table students add column version int default 1;
