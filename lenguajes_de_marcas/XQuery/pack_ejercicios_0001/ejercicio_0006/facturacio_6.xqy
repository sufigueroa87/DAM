(: Haz una lista del total de las facturas emitidas a los clientes, ordenadas de mayor a menor importe. :)

(: Primera solución :)

for $cliente in doc("facturacio.xml")//client

  let $nombreDelCliente := $cliente/descendant::nom/text()
  
  let $totalFacturasEmitidasAlCliente := $cliente/../total/string()
  
  order by number($totalFacturasEmitidasAlCliente) descending

return concat("Nombre del cliente: " , $nombreDelCliente , " || Total de las facturas al cliente: " , $totalFacturasEmitidasAlCliente)

(: Segunda solución 

for $client in doc("facturacio.xml")//factura
order by number($client/total) descending
return <client>{$client/client/raosocial/nom,$client/total}</client>

:)