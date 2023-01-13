-- 1. Crea con el usuario postgres una base de datos llamada 'Red'. 
		
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


-- 6. Crea un usuario llamado 'user0002' que sea el propietario de la base de datos 'red' y de las tablas que acabas de crear. También otórgale privilegios para crear roles y crear bases de datos. Además, se tendrá que poder validar y deberá tener el password 'secret0002' encriptado.

	-- RESPUESTA:
	-- 6.1.
		CREATE ROLE user0002
		WITH
			LOGIN
			CREATEROLE
			ENCRYPTED PASSWORD 'secret0002';
	-- miro que se haya creado bien el usuario 'user0002':
		\du user0002
	-- 6.2. 
		ALTER TABLE IF EXISTS trabajadores
		OWNER to user0002;
		
		ALTER TABLE IF EXISTS usuarios
		OWNER to user0002;

		ALTER TABLE IF EXISTS actividades
		OWNER to user0002;
		
		ALTER TABLE IF EXISTS inscripcion
		OWNER to user0002;
	-- miro que se haya modificado el propietario de las tablas
		\dt
	-- 6.3. 
		ALTER DATABASE red OWNER TO user0002;
	-- miro que se haya modificado el propietario de la base de datos red
		\l red


-- 7. Conéctate como 'user0002' a la base de datos 'red'. Crea el rol de informático, que tenga la herencia activada y control para realizar consultas, inserciones y eliminaciones sobre todas las tablas.

	-- RESPUESTA:
	-- 7.1. 
		$ psql -h 127.0.0.1 -d red -W -U user0002
	-- 7.2. 
		CREATE ROLE informatico
		WITH
			INHERIT;
	-- miro si es correcto:
		\du
	-- 7.3. 
		GRANT SELECT, INSERT, DELETE, UPDATE ON trabajadores, usuarios, actividades, inscripcion TO informatico;
	
	
-- 8. Siendo 'user0002', crea el rol de monitor sin herencia, que pueda consultar las tablas usuarios e inscripciones, y realizar todas las operaciones sobre la tabla actividades.
	
	-- RESPUESTA:
	-- 8.1.
		CREATE ROLE monitor
		WITH
			NOINHERIT;
	-- 8.2.
		GRANT SELECT ON usuarios, inscripcion TO monitor;
		
		GRANT SELECT, INSERT, DELETE, UPDATE ON actividades TO monitor;


-- 9. Siendo 'user0002', crea el rol de comercial sin herencia, que pueda realizar las cuatro operaciones sobre la tabla usuarios y sobre la tabla inscripcion, y consultas sobre la tabla actividades y sobre la tabla trabajadores.

	-- RESPUESTA:
	-- 9.1. 
		CREATE ROLE comercial
		WITH
			NOINHERIT;
	-- 9.2.
		GRANT SELECT, INSERT, DELETE, UPDATE ON usuarios, inscripcion TO comercial;
		
		GRANT SELECT ON actividades TO comercial;

-- 10. Siendo 'user0002', crea el usuario 'u0002a' con password 'secretu0002a', con herencia y asignándole el rol de monitor.

	-- RESPUESTA:
	-- 10.1. 
		CREATE USER u0002a
		WITH
			LOGIN
			PASSWORD 'secretu0002a';
	-- 10.2. 
		GRANT monitor TO u0002a;
		

-- 11. Siendo 'user0002', crea el usuario 'u0002b' con password 'secretu0002b', con herencia y asignándole el rol de informatico.

	-- RESPUESTA:
	-- 11.1.
		CREATE USER u0002b
		WITH
			LOGIN
			PASSWORD 'secretu0002b';
	-- 11.2.
		GRANT informatico TO u0002b;

-- 12. Siendo 'user0002', crea el usuario 'u0002c' con password 'secretu0002c', con herencia y asignándole el rol de comercial.

	-- RESPUESTA:
	-- 12.1. 
		CREATE USER u0002c
		WITH
			LOGIN
			PASSWORD 'secretu0002c';
	-- 12.2. 
		GRANT comercial TO u0002c;

-- 13. Siendo 'user0002' inserta en cada tabla un registro.

	-- RESPUESTA:
	-- 13.1. Inserción de registro en la tabla actividades:
		INSERT INTO actividades(nombre_actividad, descripcion, precio) VALUES('Excursión estelar', 'Excursión nocturna para ver las estrellas.', 13);
	-- 13.2. Inserción de registro en la tabla trabajadores:
		INSERT INTO trabajadores VALUES('73648298-I', 'Claudia', 'Fossas', 'Pastelera', 'claudia@gmail.com', 1000);
	-- 13.3. Inserción de registro en la tabla usuarios:
		INSERT into usuarios(nombre, apellidos, direccion, email) VALUES('Crisal', 'Sánchez', 'C/Marga 01, Flor', 'crisal@gmail.com'); 
	-- 13.4. Inserción de registro en la tabla inscripcion:
		INSERT INTO inscripcion(fk_id_usuario, fk_id_actividad, fechainicio, fechafinal) VALUES(1, 1, '20/12/22', '20/01/23');

-- 14. Accede a la tabla red siento el usuario u0002a e intenta ver todos los registros de las 3 tablas. También intenta hacer un update en cada uno de los registros.

	-- RESPUESTA:
	-- 14.1. No me deja ver los datos de la tabla trabajadores ya que tiene de herencia los privilegios de monitor, y este rol no puede ver los datos de la tabla trabajadores.
		red=> SELECT * FROM actividades;
		
 id_actividad | nombre_actividad  |                descripcion                 | precio 
--------------+-------------------+--------------------------------------------+--------
            1 | Excursión estelar | Excursión nocturna para ver las estrellas. |     13
(1 row)

		red=> SELECT * FROM inscripcion;
		
 id_inscripcion | fk_id_usuario | fk_id_actividad | fechainicio | fechafinal 
----------------+---------------+-----------------+-------------+------------
              1 |             1 |               1 | 2022-12-20  | 2023-01-20
(1 row)

		red=> SELECT * FROM trabajadores;
		ERROR:  permission denied for table trabajadores
		
		red=> SELECT * FROM usuarios;
 id_usuario | nombre | apellidos |    direccion     |      email       
------------+--------+-----------+------------------+------------------
          1 | Crisal | Sánchez   | C/Marga 01, Flor | crisal@gmail.com
(1 row)

	-- 14.2. No me deja hacer update a las tablas trabajadores, inscripcion y usuarios porque el rol monitor no lo permite.
		red=> UPDATE actividades SET precio = 15;
		UPDATE 1
		
		red=> UPDATE inscripcion SET fechafinal = '21-02-2023';
		ERROR:  permission denied for table inscripcion
		
		red=> UPDATE trabajadores SET nombre = 'Laura' WHERE dni = '73648298-I';
		ERROR:  permission denied for table trabajadores
		
		red=> UPDATE usuarios SET nombre = 'Laura' WHERE id_usuario = 1;
		ERROR:  permission denied for table usuarios

	
			
			
			
		
		
		
