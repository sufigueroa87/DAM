-- 1. Crea un usuario llamado superuser0001 con derechos de superusuario y con la password 'secret0001'.
	
	-- RESPUESTA:
	-- 1.1. con el usuario postgres:
		$ psql
	-- 1.2. 
		CREATE ROLE superuser0001
		WITH
			LOGIN
			SUPERUSER
			CREATEDB
			CREATEROLE
			INHERIT
			REPLICATION
			CONNECTION LIMIT -1
			PASSWORD 'secret0001';
	-- 1.3. miro que se haya creado correctamente el usuario superuser0001:
		\du superuser0001


-- 2. Crea un tablespace llamado tb_0001 donde añadiremos todo lo de la base de datos que crearemos posteriormente. El propietario deberá ser el usuario superuser0001:
	
	-- RESPUESTA:
	-- 2.1. con el usuario postgres:
		$ cd /var/lib/postgresql/14/main/
	-- 2.2. una vez en el directorio:
		~/14/main$ mkdir tb_0001
	-- 2.3.
		$ psql 
	-- 2.4. 
		CREATE TABLESPACE tb_0001
			OWNER superuser0001
			LOCATION '/var/lib/postgresql/14/main/tb_0001';
		ALTER TABLESPACE tb_0001
			OWNER TO superuser0001;
	-- 2.5. miro que se haya creado bien el tablespace:
		\db tb_0001


-- 3. Crea una base de datos llamada bikesharing, que se dedica a alquilar bicicletas. Haz que superuser0001 sea propietario de esta base de datos.
	
	-- RESPUESTA:
	-- 3.1.
		CREATE DATABASE bikesharing
		WITH
			OWNER = superuser0001
			ENCODING = 'UTF8'
			LC_COLLATE = 'en_US.UTF-8'
			TABLESPACE = tb_0001
			CONNECTION LIMIT = -1
			IS_TEMPLATE = False;
	-- 3.2. miro que se haya creado bien la base de datos:
		\l bikesharing


-- 4. Accede a la base de datos bikesharing con el usuario superuser0001. Crea 3 esquemas: uno llamado transportes, otro llamado personas y otro llamado administracion.
	
	-- RESPUESTA:
		$ psql -h 127.0.0.1 -d bikesharing -W -U superuser0001
	-- 3.1. con el usuario postgres:
		CREATE SCHEMA transportes
			AUTHORIZATION superuser0001;
	-- 3.2. con el usuario postgres:
		CREATE SCHEMA personas
			AUTHORIZATION superuser0001;
	-- 3.3. con el usuario postgres:
		CREATE SCHEMA administracion
			AUTHORIZATION superuser0001;
	-- 3.4. miro que se hayan creado bien todos los esquemas:
		\dn

		
-- 5. Crea la tabla bicicletas (id_bici, modelo, disponibilidad). El id_bici es de tipo serial.

	-- RESPUESTA:
		CREATE TABLE transportes.bicicletas
		(
			id_bici serial not null,
			modelo character varying(100),
			disponibilidad bool,
			CONSTRAINT "PK_id_bici" PRIMARY KEY (id_bici)
		) TABLESPACE tb_0001;
		
		ALTER TABLE IF EXISTS transportes.bicicletas
		OWNER to superuser0001;
	-- miro que se haya creado bien la tabla:
		\dt transportes.bicicletas


-- 6. Crea la tabla usuarios (id_usuario, nombre, apellidos). El id_usuario es de tipo serial.

	-- RESPUESTA:
		CREATE TABLE personas.usuarios
		(
			id_usuario serial not null,
			nombre character varying(20),
			apellidos character varying(20),
			CONSTRAINT "PK_id_usuario" PRIMARY KEY (id_usuario)
		) TABLESPACE tb_0001;
		
		ALTER TABLE IF EXISTS personas.usuarios
		OWNER to superuser0001;
	-- miro que se haya creado bien la tabla:
		\dt personas.usuarios
		

-- 7. Crea la tabla reservas (id_reserva, fk_bici, fk_usuario, fechainicio, fechafinal, precio).
	-- El atributo id_reserva es una primary key de tipo autonumérico.
	-- Los atributos fk_bici y fk_usuario son foreign key de tipo autonumérico. No pueden ser null y su integridad se actualiza en cascada.
	-- Los atributos fechainicio y fechafinal es el espacio de tiempo donde el usuario reserva la bicicleta. No pueden ser null.
	-- El atributo precio es de tipo numérico. Por defecto tiene un valor de 35 y no puede ser null.
	
	-- RESPUESTA:
		CREATE TABLE administracion.reservas
		(
			id_reserva serial not null,
			fk_bici serial not null,
			fk_usuario serial not null, 
			fechainicio date not null,
			fechafinal date not null,
			precio real,
			CONSTRAINT "PK_id_reserva" PRIMARY KEY (id_reserva),
			CONSTRAINT "PK_fk_bici" FOREIGN KEY (fk_bici) REFERENCES transportes.bicicletas (id_bici) ON UPDATE CASCADE,
			CONSTRAINT "PK_fk_usuario" FOREIGN KEY (fk_usuario) REFERENCES personas.usuarios (id_usuario) ON UPDATE CASCADE
		) TABLESPACE tb_0001;
		
		ALTER TABLE IF EXISTS administracion.reservas
		OWNER to superuser0001;

		
		
		
		
		
