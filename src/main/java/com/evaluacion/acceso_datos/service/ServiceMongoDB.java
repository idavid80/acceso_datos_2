package com.evaluacion.acceso_datos.service;

import java.util.List;
import java.util.Map;

import com.evaluacion.acceso_datos.collection.Curso;
import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.entities.Alumno;

public interface ServiceMongoDB {

	public List<Estudiante> crearEstudiante(List<Alumno> listaAlumnos);

	public List<Curso> crearCurso(Map<String, List<String>> hashMap);

	public Curso getCursoByEstudiante(String id_estudiante);

	public Estudiante getAsignaturaEstudiante(String id_estudiante);

	public List<Estudiante> getAll();

}
