-- 1. Crea con el usuario postgres una base de datos llamada "Red". 
		
	-- RESPUESTA:
	-- 1.1.
		CREATE DATABASE Red
		WITH
			OWNER = postgres
			ENCODING = 'UTF8'
			LC_COLLATE = 'en_US.UTF-8'
			CONNECTION LIMIT = -1
			IS_TEMPLATE = False;
	-- 1.2. miro que se haya creado bien la base de datos:
		\l Red

		
-- 2. Crea una tabla llamada trabajadores (dni, nombre, apellidos, trabajo, email, sueldo). 

	-- RESPUESTA:
	-- 2.1. cambio a la base de datos red:
		\c red
	-- 2.2.
		CREATE TABLE trabajadores
		(
			dni character varying (10),
			nombre character varying(20) not null,
			apellidos character varying(40) not null,
			trabajo character varying(20) not null,
			email character varying(20),
			sueldo real not null default 1100,
			CONSTRAINT "PK_dni" PRIMARY KEY (dni),
			CHECK(email ~ '@')
		);
		
		ALTER TABLE IF EXISTS trabajadores
		OWNER to postgres;
	-- miro que se haya creado bien la tabla:
		\dt transportes.bicicletas


-- 3. Crea una tabla llamada usuarios (id_usuario, dni, nombre, apellidos, direccion, email).

	-- RESPUESTA:
		CREATE TABLE usuarios
		(
			id_usuario serial,
			nombre character varying(40) not null,
			apellidos character varying(40) not null,
			direccion character varying(20) not null,
			email character varying(20),
			CONSTRAINT "PK_id_usuario" PRIMARY KEY (id_usuario),
			CHECK(email ~ '@')
		);
		
		ALTER TABLE IF EXISTS usuarios
		OWNER to postgres;
	-- miro que se haya creado bien la tabla:
		\dt usuarios
		

-- 4. Crea una tabla llamada actividades (id_actividad, nombre_actividad, descripcion, precio). 

	-- RESPUESTA:
		CREATE TABLE actividades
		(
			id_actividad serial,
			nombre_actividad character varying(40) not null,
			descripcion text,
			precio real,
			CONSTRAINT "PK_id_actividad" PRIMARY KEY (id_actividad)
		);
		
		ALTER TABLE IF EXISTS actividades
		OWNER to postgres;
	-- miro que se haya creado bien la tabla:
		\dt actividades


-- 5. Crea la tabla llamada inscripcion (id_inscripcion, fk_id_usuario, fk_id_actividad, fecha_inicio, fecha_fin). 

	-- RESPUESTA:
		CREATE TABLE inscripcion
		(
			id_inscripcion serial,
			fk_id_usuario integer not null,
			fk_id_actividad integer not null, 
			fechainicio date,
			fechafinal date,
			CONSTRAINT "PK_id_inscripcion" PRIMARY KEY (id_inscripcion),
			CONSTRAINT "PK_fk_id_usuario" FOREIGN KEY (fk_id_usuario) REFERENCES usuarios (id_usuario) ON UPDATE CASCADE,
			CONSTRAINT "PK_fk_id_actividad" FOREIGN KEY (fk_id_actividad) REFERENCES actividades (id_actividad) ON UPDATE CASCADE
		);
		
		ALTER TABLE IF EXISTS inscripcion
		OWNER to postgres;
	-- miro que se haya creado bien la tabla:
		\dt inscripcion


		
		
		
		
		
