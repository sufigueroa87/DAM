<h2> Enunciado </h2>
<hr/>

<div>
<0l>
	<li>
   		<p>
	   		Crea un usuario llamado superuser0001 con derechos de superusuario y con la password secret0001.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Crea un tablespace llamado tb_0001 donde añadiremos todo lo de la base de datos que crearemos posteriormente. El propietario deberá ser el usuario superuser0001.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Crea una base de datos llamada bikesharing, que se dedica a alquilar bicicletas. Haz que superuser0001 sea propietario de esta base de datos.

   		</p>
   	</li>
	<li>
   		<p> 
	   		Accede a la base de datos bikesharing con el usuario superuser0001. Crea 3 esquemas: uno llamado transportes, otro llamado personas y otro llamado administracion.	
   		</p>
   	</li>
	<li>
   		<p> 
	   		Crea la tabla bicicletas (id_bici, modelo, disponibilidad). El id_bici es de tipo serial.
   		</p>
   	</li>
	<li>
   		<p> 
	   		Crea la tabla usuarios (id_usuario, nombre, apellidos). El id_usuario es de tipo serial.
   		</p>
   	</li>	
   	<li>
   		<p> 
	   		Crea la tabla reservas (id_reserva, fk_bici, fk_usuario, fechainicio, fechafinal, precio).
   		</p>
   		<ul>
	   		<li>
   				El atributo id_reserva es una primary key de tipo autonumérico.
   			</li>
   			<li>
   				Los atributos fk_bici y fk_usuario son foreign key de tipo autonumérico. No pueden ser null y su integridad se actualiza en cascada.
   			</li>
   			<li>
   				Los atributos fechainicio y fechafinal es el espacio de tiempo donde el usuario reserva la bicicleta. No pueden ser null.
   			</li>
   			<li>
   				El atributo precio es de tipo numérico. Por defecto tiene un valor de 35 y no puede ser null.
   			</li>
   		</ul>
   	</li>	
</ul>
<hr/>
</div>
