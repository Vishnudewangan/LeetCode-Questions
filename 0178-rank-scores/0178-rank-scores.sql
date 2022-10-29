# Write your MySQL query statement below

select score , DENSE_RANK() OVER(
    ORDER By score desc
    
 ) As 'rank'
from Scores
