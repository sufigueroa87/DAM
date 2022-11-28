(: 1. Primer de tot necessito trobar el preu de l'estoc de cada fruita, per tant hauré de multiplicar el PREU_KG de cada fruita pel seu ESTOC_KG. Faig un bucle que faci iteració per cada fruita, i en cada iteració calculi el preu de l'estoc de cada fruita:

for $fruita_n in doc("auxiliar.xml")/ESTOC/FRUITA
  
  let $PREU_KG_fruita_n := $fruita_n/PREU_KG
  
  let $ESTOC_KG_fruita_n := $fruita_n/ESTOC_KG
  
return $PREU_KG_fruita_n * $ESTOC_KG_fruita_n :)

(: 2. Ara que ja tinc el preu de l'estoc de cada fruita, només cal sumar-los fent servir la funció sum(): :)

concat ('El preu total de lestoc de la fruiteria és de ' ,
  sum (
    
    for $fruita_n in doc("auxiliar.xml")/ESTOC/FRUITA
  
      let $PREU_KG_fruita_n := $fruita_n/PREU_KG
  
      let $ESTOC_KG_fruita_n := $fruita_n/ESTOC_KG
  
    return $PREU_KG_fruita_n * $ESTOC_KG_fruita_n
  )

, ' euros.')
