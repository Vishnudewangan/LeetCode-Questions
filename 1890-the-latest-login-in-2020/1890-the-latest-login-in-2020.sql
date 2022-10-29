# Write your MySQL query statement below
Select user_id, MAX(time_stamp) as last_stamp
from Logins
where time_stamp like '2020%'
Group by user_id