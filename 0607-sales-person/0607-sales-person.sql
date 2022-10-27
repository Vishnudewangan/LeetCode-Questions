# Write your MySQL query statement below

Select s.name
from Salesperson s 
where s.sales_id NOT IN (
                     Select o.sales_id
                     from Orders o Left Join Company c on o.com_id = c.com_id
                     where c.name = "RED"
                
                     )
                     