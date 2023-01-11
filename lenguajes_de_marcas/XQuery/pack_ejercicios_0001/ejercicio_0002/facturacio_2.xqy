(: Qué cantidad total se ha vendido de los "Porquets de xocolata"? :)

let $cantidadVendidosPorquetsXoc := doc("facturacio.xml")/sum(//producte[contains(descripcio, "Porquet de xocolata")]/quantitat)

return $cantidadVendidosPorquetsXoc
