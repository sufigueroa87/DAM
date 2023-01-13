<h2> Enunciado </h2>
<img src="https://raw.githubusercontent.com/sufigueroa87/dam/main/postgreSQL/creaci%C3%B3n_bases_de_datos_y_permisos/ejercicio_0001/base_de_datos_ejercicio_0001.jpg"> 
<hr/>

<div>
<ol>
	<li>
   		<p>
	   		Crea con el usuario postgres una base de datos llamada "Red".
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
	   		Crea una tabla llamada usuarios (id_usuario, dni, nombre, direccion, email)
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
	   		Crea la tabla llamada inscripcion (id_inscripcion, id_usuario, id_actividad, fecha_inicio, fecha_fin)
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
	   		Crea un usuario llamado master, que tenga privilegios para crear roles y usuarios. Además, se tendrá que poder validar y deberá tener el password 'luke' encriptado.
   		</p>
   	</li>	
</ol>
<hr/>
</div>
