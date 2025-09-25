-- 코드를 작성해주세요
select g.emp_no, e.emp_name, 
case 
    when avg(g.score) >= 96 then 'S'
    when avg(g.score) >= 90 then 'A'
    when avg(g.score) >= 80 then 'B'
    else 'C' 
end as grade,
case 
    when avg(g.score) >= 96 then 20
    when avg(g.score) >= 90 then 15
    when avg(g.score) >= 80 then 10
    else 0 
end / 100 * e.sal as bonus

from hr_grade as g
join hr_employees as e on g.emp_no = e.emp_no
group by g.emp_no
order by g.emp_no asc