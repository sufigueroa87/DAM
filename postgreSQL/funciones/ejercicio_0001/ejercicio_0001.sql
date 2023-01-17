-- Ejercicio_0001: Crea una función llamada resta_num que, introduciendo dos números que se pasan como parámetro, muestre por pantalla, mediante RAISE NOTICE, el resultado de hacer una resta: el primer parámetro menos el segundo. (Enunciado del Institut Obert de Catalunya (IOC))

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
