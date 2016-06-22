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
