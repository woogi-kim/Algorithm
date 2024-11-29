-- 코드를 작성해주세요

select i.id, n.fish_name, i.length
from FISH_INFO as i
left join fish_name_info as n on i.fish_type = n.fish_type
where (i.fish_type, i.LENGTH) in (select ii.fish_type, max(coalesce(ii.LENGTH, 0)) as length from fish_info as ii group by ii.fish_type)
order by i.id asc