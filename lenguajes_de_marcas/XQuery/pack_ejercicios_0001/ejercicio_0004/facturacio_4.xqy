(: Cuanto dinero se ha ingresado por la venta de los "porquets de xocolata blanca"? :)

(: Primera solución 

sum(for $producte in doc("facturacio.xml")//producte[contains(descripcio, "Porquet de xocolata blanca")]

  let $quantitatPorquetsXoc := $producte/quantitat
  
  let $preuUnitariPorquetsXoc := $producte/preuunitari

return $quantitatPorquetsXoc * $preuUnitariPorquetsXoc)

:)

(: Segunda solución :)

sum(for $producte in doc("facturacio.xml")//producte[contains(descripcio, "Porquet de xocolata blanca")]

return $producte/quantitat * $producte/preuunitari)
