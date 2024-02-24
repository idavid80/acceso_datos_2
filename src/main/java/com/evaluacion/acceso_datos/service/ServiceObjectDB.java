package com.evaluacion.acceso_datos.service;

import java.util.List;
import java.util.Map;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;

public interface ServiceObjectDB {

	// Metodos clase Asignatura
	Asignatura crearAsignatura(String asignatura, String curso);

	List<Asignatura> mostrarAsignatura();

	// metodos para intercambiar informacion
	List<Map<String, String>> hashMapCurso();

	Map<String, List<String>> getAllAsignaturaByCurso();

	List<String> getAsignaturaByCurso(String curso);

	// Metodos clase Alumno
	Alumno insertarAlumno(String nombre, String curso);

	List<Alumno> mostrarAlumno();

}
