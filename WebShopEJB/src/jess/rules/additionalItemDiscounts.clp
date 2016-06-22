(batch "jess/functions/functions.clp")

(defrule additional-item-discount-1
    "Kreiraj dodatni popust od 2% za stavku
    ukoliko je artikal iz stavke već kupovan u prethodnih 15dana."
     (declare
        (no-loop TRUE))
    ?bill <- (bill (id ?billId &nil) (date ?billDate))
    ; TODO: compare dates
    ?differentBill <- (bill (id ?id &:(<> ?id ?billId)) (date ?date &:(< (call ?billDate compareTo ?date) 15)))
    ?item <- (item (bill ?bill.OBJECT))
    ?sameItem <- (item (bill ?differentBill.OBJECT) (article ?item.article))
    =>
    (createItemDiscount ?bill ?item 0.02 (get-member DiscountType ADDITIONAL))
    )

