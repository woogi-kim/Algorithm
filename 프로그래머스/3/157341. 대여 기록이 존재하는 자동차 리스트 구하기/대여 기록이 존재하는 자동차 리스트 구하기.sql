select distinct c.car_id 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
join CAR_RENTAL_COMPANY_CAR as c on h.car_id = c.car_id
where month(h.start_date) = '10' and c.car_type = '세단'
order by c.car_id desc