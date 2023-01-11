(: Haz un listado de todos los partidos que han jugado especificando qué equipos se enfrentaban. :)

for $match in doc("6nations11.xml")//match

  let $fechaDePartido := $match/@data
  
  let $equipoA := $match/descendant::team[1]/@name
  
  let $equipoB := $match/descendant::team[2]/@name

return concat("Partido con fecha " , $fechaDePartido , " donde jugaron el equipo " , $equipoA , " contra el equipo " , $equipoB , ".")