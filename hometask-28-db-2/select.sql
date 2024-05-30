
-- Поиск людей старше 40
select *, extract(year from age(current_date, birthday_date)) :: int as age
from persons p
where extract(year from age(current_date, birthday_date)) :: int >= 18 order by age;

-- Подсчет количества людей каждого пола
select s.name, count(s.name) as count
from persons p
         inner join public.sexes s on s.id = p.sex_id
group by s.name order by count;

-- Вывод информации о персонах и их хобби
select p.id,
       p.name as name,
       p.birthday_date,
       s.name as sex,
       ARRAY(
               select distinct h.name
               from person_hobbies ph
                        inner join hobbies h on ph.hobby_id = h.id
               where ph.person_id = p.id
       )      as hobbies_list
from persons p
         inner join public.sexes s on s.id = p.sex_id;

-- Вывести список людей у которых более одного хобби
select p.name, p.id from persons p where (select count(distinct ph.hobby_id) from person_hobbies ph where ph.person_id = p.id) > 1 order by p.name;

-- Вывести какое количество активных хобби и пассивных хобби есть в бд
select ht.name, count(ht.name) as count from hobbies h inner join public.hobbies_types ht on h.type_id = ht.id group by ht.name order by count;

-- Вывести информацию какое хобби активное а какое пассивное
select h.name, ht.name as hobby_type from hobbies h inner join public.hobbies_types ht on h.type_id = ht.id order by h.name;
