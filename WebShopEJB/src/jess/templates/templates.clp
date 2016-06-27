(import model.articles.*)
(import model.payment.*)
(import model.payment.discounts.*)
(import model.users.*)
(import model.users.buyers.*)

(deftemplate article
    (declare
        (slot-specific TRUE)
        (from-class Article)
        (include-variables TRUE)))

(deftemplate articleCategory
    (declare
        (slot-specific TRUE)
        (from-class ArticleCategory)
        (include-variables TRUE)))

(deftemplate bill
    (declare
        (slot-specific TRUE)
        (from-class Bill)
        (include-variables TRUE)))

(deftemplate item
    (declare
        (slot-specific TRUE)
        (from-class Item)
        (include-variables TRUE)))

(deftemplate billDiscount
    (declare
        (slot-specific TRUE)
        (from-class BillDiscount)
        (include-variables TRUE)))

(deftemplate itemDiscount
    (declare
        (slot-specific TRUE)
        (from-class ItemDiscount)
        (include-variables TRUE)))

(deftemplate saleEvent
    (declare
        (slot-specific TRUE)
        (from-class SaleEvent)
        (include-variables TRUE)))

(deftemplate user
    (declare
        (slot-specific TRUE)
        (from-class User)
        (include-variables TRUE)))

(deftemplate buyer extends user
    (declare
        (slot-specific TRUE)
        (from-class Buyer)
        (include-variables TRUE)))

(deftemplate manager extends user
    (declare
        (slot-specific TRUE)
        (from-class Manager)
        (include-variables TRUE)))

(deftemplate seller extends user
    (declare
        (slot-specific TRUE)
        (from-class Seller)
        (include-variables TRUE)))

(deftemplate buyerCategory
    (declare
        (slot-specific TRUE)
        (from-class BuyerCategory)
        (include-variables TRUE)))

(deftemplate paymentPointsBonus
    (declare
        (slot-specific TRUE)
        (from-class PaymentPointsBonus)
        (include-variables TRUE)))

(deftemplate article
    (declare
        (slot-specific TRUE)
        (from-class Article)
        (include-variables TRUE)))

; HELPER TEMPLATES

(deftemplate itemWithDiscount
    (declare
        (slot-specific TRUE)
        )
    (slot item)
    (slot discount)
    (slot mark)
    )

(deftemplate billWithDiscount
    (declare
        (slot-specific TRUE)
        )
    (slot bill)
    (slot discount)
    )
