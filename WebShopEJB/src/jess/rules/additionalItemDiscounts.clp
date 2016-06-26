(batch "jess/functions/functions.clp")

(defrule additional-item-discount-1
    "Kreiraj dodatni popust od 2% za stavku
    ukoliko je artikal iz stavke već kupovan u prethodnih 15dana."
     (declare
        (no-loop TRUE))
    ?bill <- (bill (id ?billId &-1) (date ?billDate))
    ?differentBill <- (bill (id ?id &:(<> ?id ?billId)) (date ?date &:(< (getDateDifferenceInDays ?billDate ?date) 15)))
    ?item <- (item (bill ?bill.OBJECT))
    ?sameItem <- (item (bill ?differentBill.OBJECT) (article ?item.article))
    =>
    (createItemDiscount ?bill ?item 2 (get-member DiscountType ADDITIONAL))
    )

(defrule additional-item-discount-2
    "Kreiraj dodatni popust od 1% za stavku
    ukoliko su proizvodi iz kategorije tog artikla
    kupovani u prethodnih 30 dana."
     (declare
        (no-loop TRUE))
    ?bill <- (bill (id ?billId &-1) (date ?billDate))
    ?differentBill <- (bill (id ?id &:(<> ?id ?billId)) (date ?date &:(< (getDateDifferenceInDays ?billDate ?date) 30)))
    ?item <- (item (bill ?bill.OBJECT))
    ?article <- (article (OBJECT ?item.article))
    ?otherItem <- (item (bill ?differentBill.OBJECT))
    ?otherArticle <- (article (OBJECT ?otherItem.article) (articleCategory ?category &?article.articleCategory))
    =>
    (createItemDiscount ?bill ?item 1 (get-member DiscountType ADDITIONAL))
    )

(defrule additional-item-discount-3
    "Ukoliko datum narudžbenice
    pripada nekom vremenskom periodu akcijskog događaja
    i ukoliko za artikal iz stavke
    njegova kategorija pripada listi kategorija
    za koje se akcijski događaj definiše,
    tada kreiraj dodatni popust za stavku.
    Visina dodatnog popusta se preuzima iz akcijskog događaja."
     (declare
        (no-loop TRUE))
    ?bill <- (bill (id ?billId &-1) (date ?billDate))
    ?item <- (item (bill ?bill.OBJECT))
    ?article <- (article (OBJECT ?item.article) (articleCategory ?category))
    ?saleEvent <- (saleEvent
        (categories ?categories &:(call ?categories contains ?category))
        (actionFrom ?from &:(> (call ?billDate compareTo ?from) 0))
        (actionTo ?to &:(<= (call ?billDate compareTo ?to) 0))
        (discount ?discount))
    =>
    (createItemDiscount ?bill ?item ?discount (get-member DiscountType ADDITIONAL))
    )

