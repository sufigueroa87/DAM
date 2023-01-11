(: Cuantos puntos en total ha logrado marcar Francia en el torneo? :)

(: Primera solución :)

sum(for $team in doc("6nations11.xml")//team[@name="France"]

  let $cantidadPuntosMarcados := $team/descendant::name/@points

return $cantidadPuntosMarcados)

(: Segunda solución

let $CantidadPuntos := doc("6nations11.xml")/sum(//team[@name="France"]/descendant::name/@points)

return concat("La cantidad de puntos que ha marcado Francia es " , $CantidadPuntos , ".")

:)