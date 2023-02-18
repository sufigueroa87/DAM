(: Qué partido ha ganado Italia? :)

(: Primera solución

for $match in doc("6nations11.xml")//match[descendant::team/@name="Italy"]

  let $puntuacionItalia := $match/descendant::team[@name="Italy"]/@score
  
  let $puntuacionContrincante := $match/descendant::team[@name != "Italy"]/@score
  
  where $puntuacionItalia > $puntuacionContrincante

return $match

 :)
 
(: Segunda solución :)

for $match in doc("6nations11.xml")//match[descendant::team/@name="Italy"]

  let $maxScore := $match/max(descendant::team/@score)

  where $match/descendant::team[@name="Italy" and @score=$maxScore]

return $match