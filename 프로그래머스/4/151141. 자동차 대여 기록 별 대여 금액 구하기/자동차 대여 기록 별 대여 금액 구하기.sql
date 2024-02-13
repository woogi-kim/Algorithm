# SELECT H.HISTORY_ID,
#        C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE) + 1) *
#        ROUND(IF(DATEDIFF(H.END_DATE, H.START_DATE) + 1 <= 6 , 1, ((100 - (SELECT DISCOUNT_RATE
#                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
#                 WHERE P.CAR_TYPE = '트럭' AND DURATION_TYPE = CASE WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90
#                                                         THEN '90일 이상'
#                                                         WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30
#                                                         THEN '30일 이상'
#                                                         WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7
#                                                         THEN '7일 이상'
#                                                         END)) / 100)), 0) AS FEE
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
# INNER JOIN CAR_RENTAL_COMPANY_CAR AS C ON H.CAR_ID = C.CAR_ID
# WHERE C.CAR_TYPE = '트럭'
# ORDER BY FEE DESC, HISTORY_ID DESC;

WITH VALUE AS (
    SELECT C.DAILY_FEE, C.CAR_TYPE, H.HISTORY_ID, DATEDIFF(end_date, start_date) + 1 AS PERIOD,
    CASE 
      WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
      WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
      WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
      ELSE 'NONE' END AS duration_type
    
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    INNER JOIN CAR_RENTAL_COMPANY_CAR AS C ON H.CAR_ID = C.CAR_ID
    WHERE C.CAR_TYPE = '트럭'
)

SELECT VALUE.HISTORY_ID, ROUND(VALUE.DAILY_FEE * VALUE.PERIOD * (100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100) AS FEE 
FROM VALUE
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
    ON P.DURATION_TYPE = VALUE.DURATION_TYPE
    AND P.CAR_TYPE = VALUE.CAR_TYPE
ORDER BY FEE DESC, VALUE.HISTORY_ID DESC;