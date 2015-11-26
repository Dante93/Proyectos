<?php
	$array = json_decode($_POST["key"]);
	
	#Conectamos con MySQL
	$conexion = mysql_connect("host","nombre","password")
		or die ("Fallo en el establecimiento de la conexión");

	#Seleccionamos la base de datos a utilizar
	mysql_select_db("bd")
		or die("Error en la selección de la base de datos");
	
	
	for($i=0;$i<count($array);$i++){
		$nombre = $array[$i]->nom;
		$gen= $array[$i]->genere;
		$dur = $array[$i]->duracio;
		$dir = $array[$i]->director;
		
		$sql = "INSERT INTO Pelicula (nombre, genero, duracion, director) VALUES ('$nombre', '$gen', '$dur','$dir')";
		mysql_query($sql);
	}
?>