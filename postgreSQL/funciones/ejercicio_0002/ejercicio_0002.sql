-- Ejercicio_0002: Crea una función llamada borra_actividad que permita eliminar una actividad de la tabla actividades de manera que el código identificador de la actividad se pasará en la llamada de la función. (Enunciado del Institut Obert de Catalunya (IOC))

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
