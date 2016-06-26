(batch "jess/functions/functions.clp")

(defrule bill-original-total-price-setup
     (declare
        (no-loop TRUE)
        (salience 10))
    ?bill <- (bill)
    ?originalTotalPrice <- (accumulate
        (and (bind ?totalPrice 0) (bind ?counter 0)) ;; initializer
        (and (bind ?totalPrice (+ ?totalPrice ?price)) (bind ?counter (+ ?counter 1)));; action
        ?totalPrice ;; result
        (item
            (bill ?bill.OBJECT)
            (totalPrice ?price)
            )
        )
    =>
    (modify ?bill (originalTotalPrice ?originalTotalPrice))
    )

(defrule bill-discount-1
    "Osnovni popust od 5% na ceo račun
    ukoliko ukupna vrednost naručenih artikala
    prelazi 200000 dinara."
     (declare
        (no-loop TRUE)
        (salience 5))
    ?bill <- (bill (originalTotalPrice ?originalTotalPrice &:(> ?originalTotalPrice 200000)))
    =>
    (createBillDiscount ?bill 5 (get-member DiscountType BASE))
    )

(defrule bill-discount-2
    "Dodatni popust od 1% na ceo račun
    ukoliko je kupac korisnik sistema
    više od 2 godine (nagrađuju se stari kupci)."
     (declare
        (no-loop TRUE)
        (salience 5))
    ?bill <- (bill (buyer ?buyer) (date ?billDate))
    (buyer (OBJECT ?buyer) (registrationDate ?date &:(> (getDateDifferenceInYears ?date ?billDate) 2)))
    =>
    (createBillDiscount ?bill 1 (get-member DiscountType ADDITIONAL))
    )

(defrule bill-discount-3
    "Dodatni popust od 1% na ceo račun
    ukoliko kupac pripada kategoriji
    srebrni kupci ili zlatni kupci
    (nagrađuju se kupci sa posebnim privilegijama)."
     (declare
        (no-loop TRUE)
        (salience 5))
    ?bill <- (bill (buyer ?buyer))
    (buyer (OBJECT ?buyer) (category ?category))
    (buyerCategory (OBJECT ?category) (name ?name |"Srebrni kupac" |"Zlatni kupac"))
    =>
    (createBillDiscount ?bill 1 (get-member DiscountType ADDITIONAL))
    )

(defrule bill-discount-4
    "Dodatni popust od 3% na ceo račun
    ukoliko ukupna vrednost naručenih artikala
    prelazi 50000 dinara i ukoliko u računu
    postoje barem 10 artikala čija ukupna cena
    prelazi 50% cene ukupne vrednosti naručenih artikala."
     (declare
        (no-loop TRUE)
        (salience 5))
    ?bill <- (bill (originalTotalPrice ?originalTotalPrice &:(> ?originalTotalPrice 50000)))
    ?expensiveItems <- (accumulate
        (bind ?counter 0) ;; initializer
        (bind ?counter (+ ?counter 1));; action
        ?counter;; result
        (item
            (bill ?bill.OBJECT)
            (totalPrice ?price &:(> ?price (/ ?originalTotalPrice 2)))
            )
        )
    =>
    (createBillDiscount ?bill 3 (get-member DiscountType ADDITIONAL))
    )

