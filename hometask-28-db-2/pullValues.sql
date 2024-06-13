insert into sexes (id,name) values (1,'man'),(2,'woman');

insert into hobbies_types (id,name) values (1,'активное'), (2,'спокойное');

insert into  hobbies (id,name,type_id) values (1,'хоккей',1),(2,'футбол',1), (3, 'шахматы',2), (4,'чтение',2), (5, 'регби', 1) on conflict do nothing;

insert into persons (id,name,birthday_date,sex_id) values
                    (1,'Ivan','21-12-1999',1),
                    (2,'Kate','14-07-2000',2),
                    (3,'Alex','02-10-1999',1),
                    (4,'Petr','06-03-1977',2),
                    (5,'Natali','22-02-2002',2),
                    (6, 'Mary', '17-06-1985',2),
                    (7,'Evgeni','11-11-2011',1),
                    (8,'Evgeni','19-08-1993',2),
                    (9,'Alexandra','12-12-2012',2),
                    (10,'Alexander','07-07-2007',1);

insert into person_hobbies (person_id, hobby_id)
values (1,1),
       (1,3),
       (2,4),
       (3,1),
       (3,2),
       (4,3),
       (4,4),
       (6,1),
       (7,3),
       (8,1),
       (8,4),
       (9,1),
       (9,2),
       (9,3),
       (9,4),
       (10,5)
on conflict do nothing;