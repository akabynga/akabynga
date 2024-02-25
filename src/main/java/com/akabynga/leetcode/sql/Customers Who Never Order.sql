-- Write your PostgreSQL query statement below
select c.name as Customers
from Customers as c
         full join Orders o on o.customerId = c.id
where o.id is null