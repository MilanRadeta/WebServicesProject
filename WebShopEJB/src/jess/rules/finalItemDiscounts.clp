(batch "jess/functions/functions.clp")

(defrule final-item-discount-1
    "Za stavku računa saberi sve popuste
    (osnovni + svi dodatni) koji su za nju definisani."
    (declare
        (no-loop TRUE))
    ?bill <- (bill)
    ?item <- (item (bill ?bill.OBJECT))
    ?totalDiscount <- (accumulate
        (and (bind ?totalDiscount 0) (bind ?counter 0)) ;; initializer
        (and (bind ?totalDiscount (+ ?totalDiscount ?discount)) (bind ?counter (+ ?counter 1)));; action
        ?totalDiscount ;; result
        (itemDiscount
            (bill ?bill.OBJECT)
            (item ?item.OBJECT)
            (discountPercentage ?discount)
            )
        )
    =>
    (assert (itemWithDiscount (item ?item) (discount ?totalDiscount)))
    )

(defrule final-item-discount-2
    "Potom na osnovu kategorije artikla iz stavke
    uporedi rezultat sabiranja popusta (izražen u procentima)
    sa maksimalno dozvoljenim popustom (izražen u procentima)
    koje se primenjuje za artikle iz posmatrane kategorije.
    Ukoliko vrednost ne prelazi maksimalnu dozvoljeni popust,
    tada se rezultat upisuje u polje procenat umanjenja za stavku.
    U suprotnom se upisuje maksimalno dozvoljeni popust za artikle koji pripadaju ovoj kategoriji."
    (declare
        (no-loop TRUE))
    ?itemWithDiscount <- (itemWithDiscount (item ?item) (discount ?discount))
    ?article <- (article (OBJECT ?item.article) (articleCategory ?category))
    ?articleCategory <- (articleCategory
        (OBJECT ?category)
        (maxDiscount ?maxDiscount)
        )
    =>
    (retract ?itemWithDiscount)
    (if (< ?discount ?maxDiscount) then 
    	(modify ?item (discountPercentage ?discount))
        else
        (modify ?item (discountPercentage ?maxDiscount))
        )
    (modify ?item (originalTotalPrice (* ?item.units ?item.unitPrice)))
    (modify ?item (totalPrice (- ?item.originalTotalPrice (* ?item.originalPrice (/ ?item.discountPercentage 100)))))
    )

