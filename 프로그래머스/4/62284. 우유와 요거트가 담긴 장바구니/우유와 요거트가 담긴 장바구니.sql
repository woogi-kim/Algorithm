-- 코드를 입력하세요
SELECT DISTINCT P.CART_ID
FROM CART_PRODUCTS AS P
WHERE P.CART_ID IN (SELECT PP.CART_ID
                    FROM CART_PRODUCTS AS PP
                    WHERE PP.NAME = 'Yogurt' AND PP.CART_ID = P.CART_ID)
      AND 
      P.CART_ID IN (SELECT PP.CART_ID
                    FROM CART_PRODUCTS AS PP
                    WHERE PP.NAME = 'Milk' AND PP.CART_ID = P.CART_ID)
# GROUP BY P.CART_ID HAVING (EXISTS SELECT *
#                                   FROM CART_PRODUCTS AS PP
#                                   WHERE PP.NAME = 'Yogurt')
#                           AND 
#                           (EXISTS SELECT *
#                                   FROM CART_PRODUCTS AS PP
#                                   WHERE PP.NAME = 'Milk')
ORDER BY P.CART_ID 