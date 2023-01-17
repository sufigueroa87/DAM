CREATE DATABASE db_funciones_a
WITH
	OWNER = postgres
	ENCODING = 'UTF8'
	LC_COLLATE = 'en_US.UTF-8'
	CONNECTION LIMIT = -1
	IS_TEMPLATE = False;

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

CREATE TABLE inscripcion
(
	id_inscripcion serial,
	fk_id_usuario integer not null,
	fk_id_actividad integer not null, 
	fechainicio date,
	fechafinal date,
	CONSTRAINT "PK_id_inscripcion" PRIMARY KEY (id_inscripcion),
	CONSTRAINT "PK_fk_id_usuario" FOREIGN KEY (fk_id_usuario) REFERENCES usuarios (id_usuario) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT "PK_fk_id_actividad" FOREIGN KEY (fk_id_actividad) REFERENCES actividades (id_actividad) ON UPDATE CASCADE ON DELETE CASCADE
);

ALTER TABLE IF EXISTS inscripcion
OWNER to postgres;

INSERT INTO actividades(nombre_actividad, descripcion, precio) VALUES('Excursión estelar', 'Excursión nocturna para ver las estrellas.', 13);
INSERT INTO actividades(nombre_actividad, descripcion, precio) VALUES('Juegos acuáticos', 'Juegos para los más pequeños en el agua.', 6);
INSERT INTO actividades(nombre_actividad, descripcion, precio) VALUES('Pasteles de chocolate', 'Repostería para los más pequeños de la casa.', 19);

INSERT INTO trabajadores VALUES('73648298-I', 'Claudia', 'Fossas', 'Pastelera', 'claudia@gmail.com', 1000);
INSERT INTO trabajadores VALUES('73849238-B', 'Martín', 'García', 'Estrella', 'martin@gmail.com', 900);
INSERT INTO trabajadores VALUES('37485938-J', 'Sophy', 'Blanca', 'Cuqui', 'sophy@gmail.com', 1100);

INSERT INTO usuarios(nombre, apellidos, direccion, email) VALUES('Crisal', 'Sánchez', 'C/Marga 01, Flor', 'crisal@gmail.com');
INSERT INTO usuarios(nombre, apellidos, direccion, email) VALUES('Pablo', 'Figueras', 'C/Rosa 06, Pino', 'pablo@gmail.com');
INSERT INTO usuarios(nombre, apellidos, direccion, email) VALUES('Ignacio', 'López', 'C/Laurel 22, Aveto', 'ignacio@gmail.com');

INSERT INTO inscripcion(fk_id_usuario, fk_id_actividad, fechainicio, fechafinal) VALUES(1, 1, '20/12/22', '20/01/23');
INSERT INTO inscripcion(fk_id_usuario, fk_id_actividad, fechainicio, fechafinal) VALUES(2, 2, '13/02/22', '20/07/22');
INSERT INTO inscripcion(fk_id_usuario, fk_id_actividad, fechainicio, fechafinal) VALUES(3, 3, '04/01/21', '20/01/22');

