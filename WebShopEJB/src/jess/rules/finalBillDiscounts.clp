(batch "jess/functions/functions.clp")

(defrule final-bill-discount-1
    "Za račun saberi sve popuste (osnovni + svi dodatni)."
    (declare
        (no-loop TRUE))
    ?bill <- (bill)
    ?item <- (item (bill ?bill.OBJECT))
    ?totalDiscount <- (accumulate
        (and (bind ?totalDiscount 0) (bind ?counter 0)) ;; initializer
        (and (bind ?totalDiscount (+ ?totalDiscount ?discount)) (bind ?counter (+ ?counter 1)));; action
        ?totalDiscount ;; result
        (billDiscount (bill ?bill.OBJECT) (discountPercentage ?discount))
        )
    =>
    (assert (billWithDiscount (bill ?bill) (discount ?totalDiscount)))
    )

(defrule final-bill-discount-2
    "Potom se rezultat sabiranja popusta
    (izražen u procentima) upiše u polje
    procenat umanjenja zaračun.
    Na osnovu procenata umanjenja računa i
    konačne cene za svaku stavku računa,
    izračunaj i upiši konačnu cenu računa.
    Cena se izračunava tako što se saberu
    sve konačne cene za svaku stavku,
    te se na dobijeni zbir primeni procenat umanjenja za račun."
    (declare
        (no-loop TRUE))
    ?billWithDiscount <- (billWithDiscount (bill ?bill) (discount ?discount))
    =>
    (retract ?billWithDiscount)
	(modify ?bill (discountPercentage ?discount))
    (modify ?bill (totalPrice (- ?bill.originalTotalPrice (* ?bill.originalPrice ?discount))))
    )

