package com.evaluacion.acceso_datos.service;

import java.util.List;
import java.util.Map;

import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.entities.Alumno;

public interface ServiceMongoDB {
	
//	public String crearEstudiante(String nombre, String curso, String id_test, Integer nota);
//	public List<Estudiante> crearEstudiante();
	//String guardar(String nombre, String primerApellido, String direccion, Integer numero);
	public List<Estudiante> crearEstudiante(List<Alumno> listaAlumnos); 
	public String crearListaByCurso(Map<String, List<String>> hashMap);
	public List<String> listaCursoDB();
}
