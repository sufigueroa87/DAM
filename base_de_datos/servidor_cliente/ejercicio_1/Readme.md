**ENUNCIADO:**

1. Crea el código para crear una base de datos.

2. El código lo meteremos en un archivo creado por postgres, llamado arxiu.psql.

	$ touch arxiu.psql

3. Tras esta realización, ejecutamos el archivo arxiu.psql desde línea de comandos con el siguiente comando:
	
	$ psql postgres -f arxiu.psql
	
		o con el siguiente comando:
	
	$ psql postgres < arxiu.psql

4. Muestra el resultado de la creación de la base de datos con un diagrama.

5. Con el usuario postgres y desde línea de comandos, haz un SELECT * del contenido de una de las tablas creadas:

	$ psql postgres -c "SELECT * FROM nombreTabla;"

6. Ahora haz que la respuesta de la SELECT anterior quede guardada en un archivo llamado hola.txt:

	$ psql postgres -c "SELECT * FROM nombreTabla;" > hola.txt


