CREATE DATABASE e0001funciones
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
	CONSTRAINT "PK_fk_id_usuario" FOREIGN KEY (fk_id_usuario) REFERENCES usuarios (id_usuario) ON UPDATE CASCADE,
	CONSTRAINT "PK_fk_id_actividad" FOREIGN KEY (fk_id_actividad) REFERENCES actividades (id_actividad) ON UPDATE CASCADE
);

ALTER TABLE IF EXISTS inscripcion
OWNER to postgres;
