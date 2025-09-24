# select i.id as id, n.FISH_NAME as fish_name, max(i.length) as length
# from FISH_INFO as i
# left join FISH_NAME_INFO as n on i.fish_type = n.fish_type 
# where i.length is not null
# group by n.fish_name
# order by i.id;

select fish_info.id as ID, fish_name_info.fish_name as fish_name, maxlen.length as length
from (select fish_type, max(length) as length
        from fish_info
        where length is not null
        group by fish_type) as maxlen
join fish_info on maxlen.fish_type = fish_info.fish_type and maxlen.length = fish_info.length
join fish_name_info on fish_name_info.fish_type = maxlen.fish_type
order by fish_info.id asc

# select fish_type, max(length) as length
#         from fish_info
#         where length is not null
#         group by fish_type
