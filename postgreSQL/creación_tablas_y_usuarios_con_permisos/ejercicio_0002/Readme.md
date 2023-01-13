<h2> Enunciado </h2>
<img src="https://github.com/sufigueroa87/dam/blob/main/postgreSQL/creaci%C3%B3n_tablas_y_usuarios_con_permisos/ejercicio_0002/ejercicio_0002.jpg"> 
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
	   		Crea un usuario llamado master que sea el propietario de las tablas que acabas de crear y que tenga privilegios para crear roles y usuarios. Además, se tendrá que poder validar y deberá tener el password 'luke' encriptado.
   		</p>
   	</li>	
</ol>
<hr/>
</div>
