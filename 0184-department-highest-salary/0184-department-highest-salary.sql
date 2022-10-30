# Write your MySQL query statement below


Select  d.name as "Department" ,e.name as "Employee",e.salary as Salary
from Employee e inner join Department d on e.departmentId = d.id
where (e.departmentId , e.salary) in (
                                    Select departmentId , max(Salary)
                                    from Employee
                                    Group by departmentId
                                   
                                    );


