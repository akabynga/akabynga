-- Write your PostgreSQL query statement below
-- select distinct p1.email as Email
-- from Person p1
-- join Person p2 on p1.email = p2.email and p1.id != p2.id
select email from (select count(id),email from Person
                   group by email)
where count > 1