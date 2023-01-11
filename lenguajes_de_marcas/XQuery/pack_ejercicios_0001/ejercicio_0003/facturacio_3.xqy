(: En cuántos recibos se han vendido "Porquets de xocolata"? :)

let $cantidadRecibosPorquetsXoc := doc("facturacio.xml")/count(//rebut/descendant::producte[contains(descripcio, "Porquet de xocolata")])

return $cantidadRecibosPorquetsXoc
