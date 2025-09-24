select e.dept_id as DEPT_ID, d.DEPT_NAME_EN, round(avg(e.sal)) as AVG_SAL
from HR_EMPLOYEES as e
join HR_DEPARTMENT as d on e.dept_id = d.dept_id
group by e.dept_id
order by avg(e.sal) desc