**ENUNCIADO:**

Crea un programa que escriba una secuencia de 20 valores integers en un fichero binario llamado "Enters.bin", de manera que, empezando por el 1, cada valor sea el doble del anterior. Fíjate que no hace falta escribir ningún delimitador, los valores se van escribiendo consecutivamente, uno tras otro.
Ahora, reemplaza el fichero "Enters.bin" por 5 valores integers -1. El resultado final es un fichero de solo 20bytes, en vez de 80 bytes. Pistas: usa el método writeInt para reescribir en el archivo binario. Usa el método getFilePointer() para saber donde se encuentra el apuntador. Usa el método setLength(apuntador) para establecer la dimensión del archivo.
