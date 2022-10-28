CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      
      Select distinct(emp1.salary)
      from Employee emp1
      where (N-1) = (
                    
                       Select count(distinct emp2.salary)
                       from Employee emp2
                       where emp2.salary > emp1.salary
      )
      
  );
END