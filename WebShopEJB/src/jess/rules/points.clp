(batch "jess/templates/templates.clp")

(defrule reward-points
    "Na osnovu konačne cene računa i
    kategorije kupca identifikuj
    prag potrošnje kupca.
    Iz identifikovanog praga preuzmi procentualnu vrednost
    i primeni je na plaćenu cenu računa.
    Dobijeni broj zaokruži i upiši kao nove akcijske bodove u računu"
    (declare
        (no-loop TRUE))
    ?bill <- (bill (totalPrice ?totalPrice))
    ?buyer <- (buyer (OBJECT ?bill.buyer) (points ?points))
    ?category <- (buyerCategory (OBJECT ?buyer.category))
    (paymentPointsBonus (buyerCategory ?buyer.category) (percent ?percent) (min ?min &:(>= ?totalPrice ?min)) (max ?max &:(< ?totalPrice ?max)))
    =>
    (modify ?bill (receivedPoints (round (* (/ ?percent 100) ?totalPrice))))
    )
