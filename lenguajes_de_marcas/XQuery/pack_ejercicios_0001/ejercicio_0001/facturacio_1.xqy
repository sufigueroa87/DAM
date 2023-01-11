(: Nombre de los clientes que tienen una factura más grande de 500 €. :)

(: Primera solución 

let $nombreCliente := doc("facturacio.xml")//factura[sum(./rebut/totalrebut)>500]/client/raosocial/nom/text()
:)

(: Segunda solución 
let $otraManeraNombreCliente := doc("facturacio.xml")//factura[sum(descendant::totalrebut)>500]/client/descendant::nom/text()
:)

(: Tercera solución :)
for $factura in doc("facturacio.xml")//factura
where $factura/total>500
return $factura/client/raosocial/nom/text()
