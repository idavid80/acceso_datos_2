package com.evaluacion.acceso_datos.service;

import java.util.List;
import java.util.Map;


import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.entities.Curso;

public interface ServiceObjectDB {


	Asignatura crearAsignatura(String asignatura, String curso);
	List<Asignatura> mostrarAsignatura();

	Map<String, List<String>> getAllAsignaturaByCurso();
	Map<String, List<String>> getAsignaturaByCurso(String curso);

	List<Map<String, String>> hashMapCurso();
	Alumno insertarAlumno(String nombre, String curso);
    Curso crearCurso(String curso);
}
