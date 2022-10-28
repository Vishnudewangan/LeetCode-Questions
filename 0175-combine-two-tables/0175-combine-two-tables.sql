# Write your MySQL query statement below

Select p.firstName, p.lastName, a.city, a.state
from Person p left Join Address a on p.personId = a.personId;