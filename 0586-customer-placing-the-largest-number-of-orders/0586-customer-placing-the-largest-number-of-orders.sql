# Write your MySQL query statement below

select customer_number
from Orders
Group by customer_number
having count(order_number) = 
     (
     Select max(numOfOrder)
     from (
           Select customer_number, count(order_number) as numOfOrder
           From Orders
           Group By customer_number 
          )  as temp
        
        )