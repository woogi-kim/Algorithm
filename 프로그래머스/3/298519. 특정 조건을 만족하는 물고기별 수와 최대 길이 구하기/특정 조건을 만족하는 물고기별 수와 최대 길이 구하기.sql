-- 코드를 작성해주세요
select count(i.id) as fish_count, max(i.length) as max_length, i.fish_type as fish_type
from (
    select id, fish_type, coalesce(length, 10) as length, time
    from fish_info
) as i
group by i.fish_type having avg(i.length) >= 33
order by i.fish_type asc