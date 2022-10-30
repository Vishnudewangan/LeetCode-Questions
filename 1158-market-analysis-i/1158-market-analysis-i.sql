# Write your MySQL query statement below


Select u.user_id as buyer_id,min( u.join_date) as join_date, count(o.buyer_id) as orders_in_2019
from Users u left join Orders o on u.user_id = o.buyer_id  and YEAR(o.order_date)='2019'

group by u.user_id
