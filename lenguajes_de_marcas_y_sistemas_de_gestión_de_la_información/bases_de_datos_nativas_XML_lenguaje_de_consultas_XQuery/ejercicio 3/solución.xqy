(: 1. En aquest exercici només necessitaré la informació de les fruites que tenen Potassi, per tant les iteracions del for es faran en:

doc("auxiliar.xml")/ESTOC/FRUITA[MINERALS ="Potassi"] :)

(: 2. Ara creo el for, on en cada iteració es guardarà el nom, el tipus de venda i el preu per Kg de la fruita amb mineral Potassi trobada:)

for $fruita_n in doc("auxiliar.xml")/ESTOC/FRUITA[MINERALS = "Potassi"]
  
  let $nom_fruita_n := $fruita_n/@NOM
  
  let $tipus_venda_fruita_n := $fruita_n/VENDA/text()
  
  let $preu_kg_fruita_n := $fruita_n/PREU_KG
  
  order by $fruita_n/PREU_KG descending
  
return concat(
  'Nom de la fruita: ' , $nom_fruita_n, ' | ', 
  'Tipus de venda: ' , $tipus_venda_fruita_n, ' | ',
  'Preu per kilo: ' , $preu_kg_fruita_n, ' euros')
