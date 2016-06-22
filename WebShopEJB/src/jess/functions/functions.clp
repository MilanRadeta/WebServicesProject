(batch "jess/templates/templates.clp")

(deffunction checkCategory (?category ?name)
    (return (or
            (= ?category.name ?name)
            (and
                (<> ?cateoory.parentCategory nil)
                (= ?category.parentCategory.OBJECT.name ?name)
                )
            )
        )
    )

(deffunction createItemDiscount (?bill ?item ?discountPercentage ?type)
    (bind ?itemDiscount (definstance itemDiscount (new ItemDiscount)))
    (modify ?itemDiscount (bill ?bill.OBJECT))
    (modify ?itemDiscount (item ?item.OBJECT))
    (modify ?itemDiscount (discountPercentage ?discountPercentage))
    (modify ?itemDiscount (type ?type))
    (call ?item.discounts.OBJECT add ?itemDiscount.OBJECT)
    )

(deffunction getDateDifferenceInDays (?date1 ?date2) 
    (bind ?time1 (call ?date1 getTime)) 
    (bind ?time2 (call ?date2 getTime))
    (bind ?diffTime (- ?time2 ?time1))
    (bind ?diffDays (/ ?diffTime (* 100 60 60 24)))
    (return ?diffDays)
    )
