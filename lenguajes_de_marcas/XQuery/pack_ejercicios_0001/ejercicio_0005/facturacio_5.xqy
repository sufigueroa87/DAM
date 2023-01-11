(: En qué recibos se han vendido 3 o más artículos? :)

for $rebut in doc("facturacio.xml")//rebut[sum(descendant::quantitat)>=3]/@numero

return concat("Recibo número " , $rebut)
