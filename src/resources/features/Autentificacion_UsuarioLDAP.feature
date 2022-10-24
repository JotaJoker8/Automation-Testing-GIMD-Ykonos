@Test
Feature: Autentificación GIMD Ykonos de un usuario LDAP
	Al insertar un usuario y contraseña en la pantalla de login
	y el usuario existe en el LDAP
	y el usuario existe registrado en el sistema GIMD Ykonos
	quiero que se valide el usuario 
	para acceder a GIMD Ykonos

Background
  Given Sistema GIMD Ykonos activo
  And   Tener preparado un usuario con categoria asociada (LDAP)

  @Test_Autentificacion_UsuarioVariosCentro
	Scenario: Al insetar un usuario y contraseña válido de un usuario que pertenece a LDAP con rol asociado y tiene información de DG y CMBD, se valida el usuario y se accede la página de selección de centro con varios centros para elegir
	  Given tenemos un usuario LDAP con categoria medico
	  And   el usuario tiene definido DG
	  And   el usuario tiene definido CMBD
	  And   el usuario existe en GIMD Ykonos con varios centros asociados
	  When  se indica el usuario correctamente 
	  And   se indica la contraseña correctamente 
	  And   se da al botón 'Acceder'
	  Then  se accede a la pantalla para seleccionar el centro
	  And   se indica el nombre del usuario
	  And   se muestra el rol del usuario
	  And   se muestra la especialidad CMBD del usuario 
	  And   se muestra un combo desplegable para los centros asociados al paciente
	    
	@Test_BusquedaPaciente_Nombre_PrimerApellido
	Scenario: Búsqueda pacientes con un valor correcto de Nombre y Primer Apellido, busca en MXXI los demográficos del paciente con dichos campos
	  Given que escribimos un Nombre válido de un paciente en el campo de búsqueda Nombre
	  And   escribimos un apellido válido de un paciente en el campo de búsqueda Primer Apellido
	  When  se da al botón 'Buscar'
	  Then  se realiza la petición de los demográficos del paciente en el WS de MXXI por Nombre y Primer Apellido
	  And   se muestra en pantalla el resultado de la búsqueda
	  And   se lista en el apartado Listado Pacientes los pacientes que cumplen dichos criterios   
    
  @Test_ListadoPacientes_VariosPacientes_MasDeNueveRegistros
	Scenario: Al realizar una busqueda de pacientes y el resultado son más de nueve pacientes, se muestra el listado de paciente en una tabla paginados y por defecto aparece seleccionada la
 	primera fila
	  Given que se ha realizado una busqueda de pacientes
	  And   mas de nueve pacientes cumplen las condiciones de busqueda
	  When  se muestra el resultado de la busqueda
	  Then  muestra los pacientes en Listado de Pacientes
	  And   se muestra seleccionado por defecto la primera fila
	  And   en la parte final de la tabla del listado aparece el literal 'Total X paciente' con el numero total de pacientes encontrados
	  And   ordenados por defecto por la columna 'CIP' de forma ascendente
	  And   aparece el componente de paginacion con unos valores por defecto, 9 registros por pagina
	    
	@Test_ListadoPacientesHistorial_SeleccionPacienteDobleClic  
  Scenario: Al tener un listado de pacientes ordenados de manera ascendente por el campo CIP y se quiere seleccionar un paciente del listado
	  Given que tenemos pacientes en el listado de pacientes
	 	And   cumplen los criterios de búsqueda
	  When  se selecciona un paciente
	  Then  se hace doble clic en el listado de pacientes
	  And   se accede a la pantalla del historial del paciente  
    
  @Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_ModificarPaginacion_diez
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros que se visualizan por página a menos y mas estudios.
	  Given que se ha realizado una busqueda de un paciente con mas de 6 estudios asociados
	  And 	se carga la pantalla de detalle de los datos del historial del paciente 
	 	When 	se modifica el valor del número de estudios por página en el componente de paginación para mostrar 10 registros
	  Then 	se recarga la tabla de Historial de Paciente para mostrar el número de estudios indicados 
	  And 	al final de la lista se indica el numero de estudios encontrados 'El paciente tiene un total de X estudios asociados' 
	  And 	por defecto los estudios aparecen ordenados en orden descendente por la fecha del estudio

	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_ModificarPaginacion_quince
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros que se visualizan por página a menos y mas estudios.
	  Given que se ha realizado una busqueda de un paciente con más de 6 estudios asociados
	 	And 	se carga la pantalla de detalle de datos del historial del paciente 
	  When 	se modifica el valor del número de estudios por pagina en el componente de paginación para mostrar 15 registros
	  Then 	se recarga la tabla de Historial de Paciente para mostrar el numero de estudios indicados 
	  And 	al final de la lista se indica el número de estudios encontrados 'El paciente tiene un total de X estudios asociados' 
	  And 	por defecto los estudios aparecen ordenados en orden descendente, por la fecha del estudio
	 
	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_UltimaPagina
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros para que se visualice la ultima pagina del listado
	  Given que se ha realizado una búsqueda de un paciente con mas de 6 estudios asociados
	  And 	se carga la pantalla de detalle de los datos del historial del paciente. 
	 	When 	se modifica el componente de paginación para acceder a la última pagina del listado.
	  Then 	se recarga la tabla de Historial de Paciente para mostrar la última página.
	  And 	al final de la lista, se indica el numero de estudios encontrados 'El paciente tiene un total de X estudios asociados' 
	  And 	por defecto, los estudios aparecen ordenados en orden descendente por la fecha del estudio

	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_PrimeraPagina
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros para que se visualice la primera pagina del listado
	  Given que se ha realizado una busqueda de un paciente con mas de 6 estudios asociados.
	  And 	se carga la pantalla de detalle de los datos, del historial del paciente
	  When 	se modifica el componente de paginación para acceder a la primera pagina del listado.
	  Then 	se recarga la tabla de Historial de Paciente para mostrar la primera página.
	  And 	al final de la lista se indica el numero de estudios encontrados 'El paciente, tiene un total de X estudios asociados' 
	  And 	por defecto, los estudios aparecen ordenados en orden descendente, por la fecha del estudio

	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_PaginaDerecha
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros para que se visualice la siguiente pagina a la derecha del listado
	  Given que se ha realizado una busqueda de un paciente, con mas de 6 estudios asociados
	  And 	se carga la pantalla de detalle de los datos, del historial del paciente. 
	  When 	se modifica el componente de paginación para acceder a la siguiente pagina a la derecha del listado.
	  Then 	se recarga la tabla de Historial de Paciente para mostrar la siguiente página a la derecha.
	  And 	al final de la lista, se indica el numero de estudios encontrados 'El paciente, tiene un total de X estudios asociados' 
	  And 	por defecto los estudios aparecen ordenados, en orden descendente, por la fecha del estudio

	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_PaginaIzquierda
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros para que se visualice la siguiente pagina a la izquierda del listado
	 	Given se ha realizado una busqueda de un paciente con mas de 6 estudios asociados
	  And 	se carga, la pantalla de detalle de los datos del historial del paciente 
	  When 	se modifica el componente de paginación para acceder a la siguiente pagina a la izquierda del listado.
	  Then 	se recarga la tabla de Historial de Paciente para mostrar la siguiente página a la izquierda.
	  And 	al final, de la lista se indica el numero de estudios encontrados 'El paciente tiene un total de X estudios asociados' 
	  And 	por defecto, los estudios aparecen ordenados, en orden descendentes por la fecha del estudio

	@Test_ListadoEstudiosHistorial_VariosEstudios_MasdeSeisRegistros_PaginaAleatoria
	Scenario: Al seleccionar un paciente cuyo historial tiene mas de 6 estudios asociados, se carga la pantalla con los datos del paciente y muestra esos estudios en el listado de historial y se modifica el número de registros para que se visualice una página aleatoria del listado
	  Given se ha realizado una busqueda de un paciente con más de 6 estudios asociados
	  And 	se carga la pantalla de detalle de datos del historial del paciente.
	  When 	se modifica el componente de paginación para acceder a una página aleatoria del listado.
	  Then 	se recarga la tabla de Historial de Paciente para mostrar una página aleatoria del listado.
	  And 	al final, de la lista se indica el numero de estudios encontrados 'El paciente, tiene un total de X estudios asociados
	  And 	por defecto los estudios, aparecen ordenados en orden descendentes por la fecha del estudio
	  