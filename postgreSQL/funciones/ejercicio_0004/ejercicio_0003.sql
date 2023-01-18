-- Ejercicio_0004: . (Enunciado del Institut Obert de Catalunya (IOC))

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

	
	
