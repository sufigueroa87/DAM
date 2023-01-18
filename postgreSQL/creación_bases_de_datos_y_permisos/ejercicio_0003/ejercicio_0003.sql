-- 1. Crea con el usuario postgres una base de datos llamada donpiso, que se encargará de gestionar las oficinas, los empleados y los clientes de la empresa.
		
	-- RESPUESTA:
	-- 1.1.
		CREATE DATABASE donpiso
		WITH
			OWNER = postgres
			ENCODING = 'UTF8'
			LC_COLLATE = 'en_US.UTF-8'
			CONNECTION LIMIT = -1
			IS_TEMPLATE = False;
	-- 1.2. miro que se haya creado bien la base de datos:
		\l donpiso

		
-- 2. Entra con el usuario postgres a la base de datos donpiso y crea un usuario llamado admin0003 con password 'secret0003'. Haz que el propietario de la base de datos donpiso sea admin0003.

	-- RESPUESTA:
	-- 2.1. 
		\c donpiso
	-- 2.2.
		CREATE ROLE admin0003
		WITH
			LOGIN
			SUPERUSER
			CREATEDB
			CREATEROLE
			INHERIT
			REPLICATION
			CONNECTION LIMIT -1
			PASSWORD 'secret0003';
	-- 2.3.
		ALTER DATABASE donpiso
			OWNER TO admin0003;
	-- 2.4.
		\l


-- 3. Accede a la base de datos donpiso con el usuario admin0003.

	-- RESPUESTA:
	-- 3.1.
		$ psql -h 127.0.0.1 -d donpiso -W -U admin0003


-- 4. Crea 2 esquemas para esta base de datos: el rrhh y el ventas:

	-- RESPUESTA:
	-- 4.1. 
		CREATE SCHEMA rrhh
			AUTHORIZATION admin0003;
	
	-- 4.2.
		CREATE SCHEMA ventas
			AUTHORIZATION admin0003;
	-- 4.3.
		\dn
			
		
-- 5. Con el usuario admin0003, crea la tabla oficinas(id_ofi, direccion) y la tabla empleados(id_emp, nombre, apellidos, salario, oficina, jefe), que irán dentro del esquema rrhh:
	-- la dirección no puede ser null
	-- el atributo jefe hace referencia a otro empleado, puede ser null, y la integridad borra a null y actualiza en cascada
	-- el atributo oficina hace referencia a una oficina, no puede ser null, y la integridad borra y actualiza en cascada
	-- Los atributos nombre y apellidos no pueden ser null
	-- El atributo salario por defecto tiene un valor 1000 y no puede ser null.
	
	-- RESPUESTA:
	-- 5.1. 
		SET SEARCH_PATH TO rrhh;
		
		CREATE TABLE oficinas (
			id_ofi serial,
			direccion character varying(100) not null,
			CONSTRAINT "PK_id_ofi" PRIMARY KEY (id_ofi)
			);
	-- 5.2.
		\d rrhh.oficinas	
	-- 5.3.
		SET SEARCH_PATH TO rrhh;
	
		CREATE TABLE empleados (
			id_emp serial,
			nombre character varying(50) not null,
			apellidos character varying(100) not null,
			salario real not null default 1000,
			fk_oficina integer not null,
			fk_jefe integer,
			CONSTRAINT "PK_id_emp" PRIMARY KEY (id_emp),
			CONSTRAINT "FK_fk_oficina" FOREIGN KEY (fk_oficina) REFERENCES oficinas(id_ofi) ON UPDATE CASCADE ON DELETE CASCADE,
			CONSTRAINT "FK_fk_jefe" FOREIGN KEY (fk_jefe) REFERENCES empleados(id_emp) ON UPDATE CASCADE ON DELETE SET NULL
		);
	-- 5.4.
		\d rrhh.empleados


-- 6. Con el usuario admin0003, crea la tabla clientes(id_cli, dni, nombre, apellidos, mail, oficina) dentro del esquema ventas:
	-- el atributi dni es único y no puede ser null
	-- los atributos nombre y apellidos no pueden ser null
	-- el atributo mail no puede ser null
	-- el atributo oficina hace referencia a una oficina, puede ser null, y la integridad borra a null y actualiza en cascada.
	
	-- RESPUESTA:
	-- 6.1. 
		SET SEARCH_PATH TO ventas;
		
		CREATE TABLE clientes (
			id_cli serial,
			dni character varying(10) unique not null,
			nombre character varying(50) not null,
			apellidos character varying(100) not null,
			mail character varying(20) not null,
			fk_oficina integer,
			CONSTRAINT "PK_dni" PRIMARY KEY (id_cli),
			CONSTRAINT "FK_fk_oficina" FOREIGN KEY (fk_oficina) REFERENCES rrhh.oficinas(id_ofi) ON UPDATE CASCADE ON DELETE SET NULL,
			CHECK(mail ~ '@')
		);
	-- 6.2.
		\d ventas.clientes
		

		
		
