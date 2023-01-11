(: En qué partidos ha jugado Escocia? :)

for $match in doc("6nations11.xml")//match[descendant::team/@name="Scotland"]

  let $nombreDelEquipo1 := $match/descendant::team[1]/@name
  
  let $nombreDelEquipo2 := $match/descendant::team[2]/@name

return concat("Partido: " , $nombreDelEquipo1 , " contra " , $nombreDelEquipo2 , ".")