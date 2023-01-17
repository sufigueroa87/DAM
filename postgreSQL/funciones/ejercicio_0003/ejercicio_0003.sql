-- Ejercicio_0003: Crea una función llamada f_info_trabajador usando cursores que devuelva el dni, el nombre, los apellidos y el sueldo del trabajador introducido por parámetro. Usa un tipo compuesto llamado info_trabajador. Si no existe el trabajador, muestra un mensaje conforme no existe el trabajador. (Enunciado del Institut Obert de Catalunya (IOC))

	-- RESPUESTA:
	CREATE TYPE info_trabajador AS (
		dni character varying (10),
		nombre character varying(20),
		apellidos character varying(40),
		sueldo real);
	
	CREATE OR REPLACE FUNCTION f_info_trabajador(dni_elegido trabajadores.dni%TYPE)
	RETURNS setof info_trabajador AS $$
	DECLARE
		datos_trabajador info_trabajador;
		existe integer;
		cursor CURSOR FOR
			SELECT dni, nombre, apellidos, sueldo
			FROM trabajadores
			WHERE dni = $1;
	BEGIN
		SELECT count(dni) INTO existe FROM trabajadores WHERE dni = $1;	
		IF existe = 1 THEN
			RAISE NOTICE 'El trabajador existe.';
			OPEN cursor;
			LOOP
				FETCH cursor INTO datos_trabajador;
				EXIT WHEN NOT FOUND;
				RETURN next datos_trabajador;
			END LOOP;
			CLOSE cursor;
		ELSE
			RAISE NOTICE 'El trabajador no existe.';
		END IF;
	EXCEPTION
		WHEN others THEN RAISE EXCEPTION' P0001: Error intern';
	END;
	$$
	LANGUAGE plpgsql;

	
	
