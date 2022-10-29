# Write your MySQL query statement below

Select Distinct u.name, IFNULL(sum(distance) Over (Partition by u.id) , 0) as travelled_distance
from Users u Left Join Rides r on u.id = r.user_id
Order by travelled_distance desc, u.name asc;
