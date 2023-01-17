-- 1. Crea una función llamada resta_num que, introduciendo dos números que se pasan como parámetro, muestre por pantalla, mediante RAISE NOTICE, el resultado de hacer una resta: el primer parámetro menos el segundo.

	-- RESPUESTA:
	CREATE OR REPLACE FUNCTION resta_num(a integer, b integer)
	RETURNS integer AS $$
	DECLARE
	resultat integer;
	BEGIN
	resultat := $1 - $2;
	RAISE NOTICE ' El valor del resultat correspon a % ', resultat;
	RETURN resultat;
	END;
	$$ LANGUAGE plpgsql;


-- 2. Crea una función llamada borra_actividad que permita eliminar una actividad de la tabla de actividades de manera que el código identificador de la actividad se pasará en la llamada de la función.

	-- RESPUESTA:
	CREATE OR REPLACE FUNCTION borra_actividad(codigo_actividad public.actividades.id_actividad%TYPE)
	RETURNS void AS $$
	DECLARE
		existe integer;
		nombreactividad public.actividades.nombre_actividad%TYPE;
	BEGIN	
		SELECT count(nombre_actividad) INTO existe FROM actividades WHERE id_actividad = $1;
		IF existe != 0 THEN
			SELECT nombre_actividad INTO nombreactividad FROM actividades WHERE id_actividad = $1;
			DELETE FROM actividades WHERE id_actividad = $1; 
			RAISE NOTICE 'Se ha producido el borrado de la actividad %.', nombreactividad;
		ELSE
			RAISE NOTICE 'No existe el id_actividad de la actividad introducida que se desea borrar, por lo tanto no se puede borrar.';
		END IF;
	EXCEPTION
		WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
	END;
	$$ LANGUAGE plpgsql;
	
	
-- 3. Crea una función que cuente voluntarios.

CREATE FUNCTION compta_voluntaris(idvoluntari gestio.voluntaris.id_vol%TYPE)
RETURNS gestio.voluntaris.id_vol%TYPE AS $$
DECLARE
resultat gestio.voluntaris.id_vol%TYPE;
BEGIN
SELECT count(id_vol) into resultat
FROM gestio.voluntaris
WHERE id_vol < idvoluntari;
RETURN resultat;
END;
$$ LANGUAGE plpgsql;

/*implementar, mitjançant la sobrecàrrega de funcions, una funció que,
depenent del tipus de paràmetre que li passem, ens retorni un tipus de dada o un altre. Amb aquesta funció
treballareu els cursors en operacions de selecció simples:
La funció s'anomenarà dades_voluntaris.

En cas que se li passi com a paràmetre un número, retornarà el telèfon d’aquells voluntaris amb un
identificador igual o superior al passat com a paràmetre. La implementació de la funció es farà
emprant cursors.

En cas que se li passi com a paràmetre una cadena de caràcters (varchar), retornarà el cognom
d’aquells voluntaris que el seu nom coincideixi amb la cadena de caràcters introduïda. La
implementació de la funció es farà emprant cursors.*/
	
➤ RESPOSTA: Creo la funció dades_voluntaris(numero integer):
-- com que ha d'estar a l'esquema public, no cal que declari l'esquema
CREATE OR REPLACE FUNCTION dades_voluntaris(numero integer)
RETURNS VOID AS $BODY$
DECLARE
	cursor CURSOR FOR
SELECT telefon
FROM gestio.voluntaris
WHERE id_vol = $1 OR id_vol > $1;
	registre RECORD;
BEGIN

	FOR registre IN cursor LOOP
		RAISE NOTICE 'telèfon del client: %', registre.telefon;

	END LOOP;
	
EXCEPTION
-- per si es donen errors
WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
END;
$BODY$
LANGUAGE plpgsql;
	
CREATE OR REPLACE FUNCTION dades_voluntaris(nom_voluntari TEXT)
RETURNS VOID AS $BODY$
DECLARE
	cognoms_trobats gestio.voluntaris.cognoms%TYPE;
	cursor CURSOR FOR
		SELECT cognoms
		FROM gestio.voluntaris
		WHERE nom = $1;
BEGIN
OPEN cursor;
LOOP
	FETCH cursor INTO cognoms_trobats;
		EXIT WHEN NOT FOUND;
	RAISE NOTICE 'cognoms del voluntari: %', cognoms_trobats;
END LOOP;
CLOSE CURSOR;
EXCEPTION
-- per si es donen errors
WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
END;
$BODY$
LANGUAGE plpgsql
	
	
	
/*
implementar una funció emprant cursors en la iteració d’una operació de
selecció de més d’un camp amb múltiples resultats mitjançant un tipus compost.
•
Implementeu una funció anomenada info_voluntaris. Se li passarà com a paràmetre un valor
numèric, i retornarà un tipus compost anomenat tinfo que contindrà els camps corresponents a
l’identificador del voluntari, nom i cognoms d’aquells voluntaris amb un codi inferior al valor numèric
que se li passa com a paràmetre. La implementació de la funció es farà emprant cursors.
*/

CREATE TYPE tinfo AS (
id_vol integer,
nom character varying(100),
cognoms character varying(100));

CREATE OR REPLACE FUNCTION info_voluntaris(numero integer)
RETURNS setof tinfo AS $$
DECLARE
	dades_voluntari tinfo;
	id_vol menor al numero introduït:
	cursor CURSOR FOR
		SELECT id_vol, nom, cognoms
		FROM gestio.voluntaris
		WHERE id_vol < $1;
BEGIN
OPEN cursor;
LOOP
FETCH cursor INTO dades_voluntari;
EXIT WHEN NOT FOUND;
RETURN next dades_voluntari;
END LOOP;
CLOSE cursor;
EXCEPTION
WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
END;
$$
LANGUAGE plpgsql;




/*
Interpreteu i adapteu la següent funció (heu de revisar i modificar les dades marcades en groc)
anomenada clients_antics(), per tal que permeti obtenir un conjunt de dades corresponent als tres primers
clients que s’hagin donat d’alta a la base de dades. Donarem per suposat que l’antiguitat ve relacionada
amb el codi del client. A mesura que es van introduint clients a la base de dades el codi va creixent, per tant,
els més antics seran aquells amb un codi més baix. Traurem el seu codi, nom i data naixement (cal que
definiu prèviament el tipus t_client)
*/
CREATE TYPE t_client AS (
codi_client integer,
nom character varying(50),
data_naix date);

CREATE OR REPLACE FUNCTION clients_antics()
RETURNS setof t_client AS
$$
DECLARE
client t_client;
numero integer;
curs1 CURSOR FOR
	SELECT codi_client, nom, data_naix
	FROM vendes.clients
ORDER BY codi_client ASC;
BEGIN
OPEN curs1;
FOR numero IN 1..3 LOOP
FETCH curs1 INTO client;
EXIT WHEN NOT FOUND;
RETURN next client;
end LOOP;
CLOSE curs1;
EXCEPTION
-- per si es donen altres errors
WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
END;
$$
LANGUAGE plpgsql;
	
/*
CREACIÓ VISTA
Creeu, dins l’esquema recursos, una vista de pagesos amb totes les seves dades (codi del pagés,
nom i cognoms, telèfon, e-mail, càrrec i codi del local al qual estan associats), més el nom comercial del
local al qual estan associats. Anomeneu info_pages a la vista i ha d'estar a l'esquema recursos.
*/
CREATE VIEW recursos.info_pages AS
SELECT c.codipages, c.nom, c.cognoms, c.telefon, c.email, c.carrec, c.codilocal,
l.nomcomercial
FROM recursos.locals l, recursos.pagesos c
WHERE c.codilocal = l.codilocal;

/*
Feu que la vista info_pages s’ubiqui a l’esquema public i verifiqueu la funcionalitat del canvi
*/
ALTER VIEW recursos.info_pages
SET SCHEMA public;

	
/*
REGLA INSERCIÓ
Creeu una regla d'inserció anomenada ins_info_pages que permeti inserir registres a la taula
recursos.pagesos per mitjà de la vista public.info_pages. Apliqueu la regla i inseriu un registre a la vista
creada.
*/
CREATE RULE ins_info_pages AS
ON INSERT TO public.info_pages
DO INSTEAD
INSERT INTO recursos.pagesos (codipages, nom, cognoms, telefon, email, carrec,
codilocal)
VALUES (new.codipages, new.nom, new.cognoms, new.telefon, new.email, new.carrec,
new.codilocal);

INSERT INTO public.info_pages(codipages, nom, cognoms, telefon, email, carrec,
codilocal)
VALUES (22,'Nuria','Salvado','12312312','nsalvado@aaa.com','administratiu',1);

	
/*
REGLA QUE PERMETI BORRAR REGISTRES
Creeu una regla anomenada del_info_pages que permeti eliminar registres de la taula
recursos.pagesos per mitjà de la vista public.info_pages creada anteriorment
*/

CREATE RULE del_info_pages AS
ON DELETE TO public.info_pages
DO INSTEAD
DELETE FROM recursos.pagesos
WHERE codipages=OLD.codipages;

	
	
	
	
	
	
	
	
	
	
	
	
