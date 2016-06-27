(batch "jess/functions/functions.clp")

(defrule base-item-discount-1
    "Kreiraj osnovni popust od 10% za stavku
    ukoliko se u njoj narucuje vise od 20 artikla,
    a artikal ne pripada kategoriji siroke potrosnje"
    (declare
        (no-loop TRUE)
        (salience 10))
    ?bill <- (bill)
    ?item <- (item
        (bill ?bill.OBJECT)
        (units ?units &:(> ?units 20)))
    (not (itemDiscount (bill ?bill.OBJECT) (item ?item.OBJECT) (type ?type &=(get-member DiscountType BASE))))
    =>
    (createItemDiscount ?bill ?item 10 (get-member DiscountType BASE))
    )

(defrule base-item-discount-2
    "Kreiraj osnovni popust od 5% za stavku
    ukoliko se u njoj narucuje vise od 5 artikla,
    a artikal pripada kategoriji televizori, racunari ili laptopovi"
    (declare
        (no-loop TRUE)
        (salience 1))
    ?bill <- (bill)
    ?item <- (item
        (bill ?bill.OBJECT)
        (units ?units &:(> ?units 5)))
    ?article <- (article (OBJECT ?item.article))
    ?category <- (articleCategory (OBJECT ?article.articleCategory) (name ?name |"Televizori" |"Računari" |"Laptopovi"))
    (not (itemDiscount (bill ?bill.OBJECT) (item ?item.OBJECT) (type ?type &=(get-member DiscountType BASE))))
    =>
    (createItemDiscount ?bill ?item 5 (get-member DiscountType BASE))
    )

(defrule base-item-discount-3
    "Kreiraj osnovni popust od 7% za stavku
    ukoliko ukupna narucena vrednost stavke
    prelazi 5000 din i ukoliko njen artikal
    pripada kategoriji siroke potrošnje"
    (declare
        (no-loop TRUE)
        (salience 5))
    ?bill <- (bill)
    ?item <- (item
        (bill ?bill.OBJECT)
        (units ?units)
        (unitPrice ?unitPrice))
    ?article <- (article (OBJECT ?item.article))
    ?category <- (articleCategory (name ?name) (consumerArticle ?consumerArticle &TRUE) (OBJECT ?article.articleCategory))
    (test (> (* ?unitPrice ?units) 5000))
    (not (itemDiscount (bill ?bill.OBJECT) (item ?item.OBJECT) (type ?type &=(get-member DiscountType BASE))))
    =>
    (createItemDiscount ?bill ?item 7 (get-member DiscountType BASE))
    )