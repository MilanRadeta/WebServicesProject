(batch "jess/templates/templates.clp")

(defrule mark-article
    "Ako je brojno stanje artikla manje od minimalnog, postavi naznaku u artiklu."
    ?article <- (article (inStock ?inStock) (minInStock ?minInStock &:(< ?inStock ?minInStock)))
    =>
    (modify ?article (neededInStock TRUE))
    )
