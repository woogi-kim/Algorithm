select u.user_id as user_id, u.nickname as nickname, concat(u.CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) as 전체주소, concat(substring(tlno, 1, 3), '-', substring(tlno, 4, 4), '-', substring(tlno, 8, 4)) as 전화번호

from USED_GOODS_BOARD as b
join USED_GOODS_USER u on b.writer_id = u.user_id
group by u.user_id having count(u.user_id) >= 3
order by u.user_id desc