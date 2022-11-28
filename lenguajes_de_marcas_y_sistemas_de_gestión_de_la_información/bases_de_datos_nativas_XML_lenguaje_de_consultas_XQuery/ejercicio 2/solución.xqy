(: 1. En aquest exercici només necessitaré la informació de les fruites que tenen un element fill <PACK_APROX_GR>, per tant les iteracions del for es faran en:

doc("auxiliar.xml")/ESTOC/FRUITA[PACK_APROX_GR] :)


(: 2. Per conèixer els packs que podem fer amb la quantitat de fruita que tenim de cada fruita, primer passaré els kilograms de fruita a grams i guardaré aquesta quantitat en una variable nova anomenada $mg_totals_fruita_n:

for $fruita_n in doc("auxiliar.xml")/ESTOC/FRUITA[PACK_APROX_GR]
  
  let $mg_totals_fruita_n := $fruita_n/ESTOC_KG * 1000
  
return $mg_totals_fruita_n :)


(: 3. Ara ja només cal dividir la quantitat de miligrams que tenim per la quantitat de miligrams que forma cada pack de fruita: :)

for $fruita_n in doc("auxiliar.xml")/ESTOC/FRUITA[PACK_APROX_GR]
  
  let $mg_totals_fruita_n := number($fruita_n/ESTOC_KG * 1000)
  
  let $mg_cada_pack_fruita_n := number($fruita_n/PACK_APROX_GR)
  
  let $quantitat_packs_fruita_n := $mg_totals_fruita_n div $mg_cada_pack_fruita_n
  
  let $nom_fruita_n := $fruita_n/@NOM
  
return concat('La quantitat de packs que podem fer de la fruita ' , $nom_fruita_n , ' és ', $quantitat_packs_fruita_n, '.')