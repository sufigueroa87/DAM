<h2> Enunciado </h2>
<img src="https://raw.githubusercontent.com/sufigueroa87/dam/main/postgreSQL/creaci%C3%B3n_bases_de_datos_y_permisos/ejercicio_0002/ejercicio_0002.jpg"> 
<hr/>

<div>
<ol>
	<li>
   		<p>
	   		Crea con el usuario postgres una base de datos llamada red.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Crea una tabla llamada trabajadores (dni, nombre, apellidos, trabajo, email, sueldo).
	   	</p>
	   	<ol>
	   		<li>
   				Los atributos nombre y apellido es de tipo alfanumérico. No pueden ser null.
   			</li>
   			<li>
   				El atributo sueldo es de tipo numérico. Por defecto tiene un valor 1100 y no puede ser null.
   			</li>
   			<li>
   				El atributo trabajo es tipo alfanumérico. No puede ser null.
   			</li>
   			<li>
   				El atributo dni es de tipo alfanumérico. Es único y no puede ser null (será clave primária).
   			</li>
   		</ol>
   	</li>
	<li>
   		<p> 
	   		Crea una tabla llamada usuarios (id_usuario, dni, nombre, apellidos, direccion, email)
   		</p>
	   	<ol>
	   		<li>
   				El atributo id_usuario es único y no puede ser null (será clave primária de tipo serial).
   			</li>
   			<li>
   				Los atributos nombre y apellidos son de tipo alfanumérico. No pueden ser null.
   			</li>
   			<li>
   				El atributo direccion es de tipo alfanumérico. No puede ser null.
   			</li>
   			<li>
   				El atributo email es de tipo alfanumérico. No puede ser null.
   			</li>
  			<li>
   				El atributo dni es de tipo alfanumérico. Es único y no puede ser null.
   			</li>
   		</ol>
   	</li>
	<li>
   		<p> 
	   		Crea una tabla llamada actividades (id_actividad, nombre_actividad, descripcion, precio)	
   		</p>
	   	<ol>
	   		<li>
   				El atributo id_actividad es único y no puede ser null (será clave primária de tipo serial).
   			</li>
   			<li>
   				El atributo nombre_actividad es de tipo alfanumérico. No puede ser null.
   			</li>
   			<li>
   				El atributo descripcion es de tipo alfanumérico.
   			</li>
   			<li>
   				El atributo precio es de tipo numérico.
   			</li>
   		</ol>
   	</li>
	<li>
   		<p> 
	   		Crea la tabla llamada inscripcion (id_inscripcion, fk_id_usuario, kf_id_actividad, fecha_inicio, fecha_fin)
   		</p>
	   	<ol>
	   		<li>
   				El atributo id_inscripcion es único y no puede ser null (será la clave primária de tipo serial).
   			</li>
   			<li>
   				El atributo id_usuario hace referencia a un usuario, no puede ser null, y la integridad actualiza en cascada. Es clave foránea de id_usuario de la tabla usuarios.
   			</li>
   			<li>
   				El atributo id_usuario, hace referencia a una actividad, no puede ser null, y la integridad actualiza en cascada. Es clave foránea de id_actividad de la tabla actividades.
   			</li>
   			<li>
   				El atributo fecha_inicio y fecha_fin tendrán valores de fechas.
   			</li>
   		</ol>
   	</li>
	<li>
   		<p> 
	   		Crea un usuario llamado user0002 que sea el propietario de la base de datos red y de las tablas que acabas de crear. También otórgale privilegios para crear roles y crear bases de datos. Además, se tendrá que poder validar y deberá tener el password 'luke' encriptado.
   		</p>
   	</li>	
	<li>
   		<p> 
	   		Conéctate como user0002 a la base de datos red. Crea el rol de informático, que tenga la herencia activada y control para realizar consultas, inserciones y eliminaciones sobre todas las tablas.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Siendo user0002, crea el rol de monitor sin herencia, que pueda consultar las tablas usuarios e inscripciones, y realizar todas las operaciones sobre la tabla actividades.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Siendo user0002, crea el rol de comercial sin herencia, que pueda realizar las cuatro operaciones sobre la tabla usuarios y sobre la tabla inscripcion, y consultas sobre la tabla actividades y sobre la tabla trabajadores.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Siendo user0002, crea el usuario u0002a con password 'secretu0002a', con herencia y asignándole el rol de monitor.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Siendo user0002, crea el usuario u0002b con password 'secretu0002b', con herencia y asignándole el rol de informatico.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Siendo user0002, crea el usuario u0002c con password 'secretu0002c', con herencia y asignándole el rol de comercial.
   		</p>
   	</li>
   	<li>
   		<p> 
	   		Siendo user0002 Inserta en cada tabla un registro.
   		</p>
   	</li>
   	</li>
   	<li>
   		<p> 
	   		Accede a la tabla red siento el usuario u0002a e intenta ver todos los registros de las 3 tablas. También intenta hacer un update en cada uno de los registros.
   		</p>
   	</li>
</ol>
<hr/>
</div>
