package com.evaluacion.acceso_datos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.repository.RepositoryObjectDB;

@Service
public class ServiceObjectDBImpl implements ServiceObjectDB {

	@Autowired
	protected RepositoryObjectDB repo;

	// Creamos una clase asignatura en la base de datos
	public Asignatura crearAsignatura(String asignatura, String curso) {
		
		// !ATENCION¡ Pendiente crear estructura de control para duplicidad
		
		return repo.crearAsignatura(asignatura, curso);
	}
	// Obtenemos una lista de clase asignatura de la base de datos
	public List<Asignatura> mostrarAsignatura() {
		return repo.mostrarAsignatura();
	}

	// Pasamos la lista que genera mostrarAsignatura a un hashmap
	public List<Map<String, String>> hashMapCurso() {

		List<Asignatura> listaAsignatura = repo.mostrarAsignatura();
		List<Map<String, String>> hashAsignatura = new ArrayList<>();

		for (Asignatura asignatura : listaAsignatura) {
			hashAsignatura.add(Map.of("asignatura", asignatura.getAsignatura(), "curso", asignatura.getCurso()));
		}
		return hashAsignatura;
	}

	// Con el hashMapCurso, clasificamos las asignaturas por cursos
	public Map<String, List<String>> getAllAsignaturaByCurso() {

		List<Map<String, String>> listaCursos = hashMapCurso();
		Map<String, List<String>> asignaturasPorCurso = new HashMap<>();
		for (Map<String, String> asignatura : listaCursos) {

			// Obtenermos los valores por las claves curso y asignatura
			String curso = asignatura.get("curso");
			String asignaturaNombre = asignatura.get("asignatura");
			// insertamos como clave los valores de curso y añadimos en una lista los
			// valores de asignaturas
			asignaturasPorCurso.putIfAbsent(curso, new ArrayList<>());
			asignaturasPorCurso.get(curso).add(asignaturaNombre);
		}
		return asignaturasPorCurso;
	}

	// Obtenemos una lista de asignaturas por curso
	public List<String> getAsignaturaByCurso(String curso) {

		List<String> listaAsignatura = new ArrayList<>();
		Map<String, List<String>> hashMapCurso = getAllAsignaturaByCurso();
		
		if (hashMapCurso.containsKey(curso)) {
			List<String> AsignaturasPorCurso = hashMapCurso.get(curso);

			for (String asingnatura : AsignaturasPorCurso) {

				listaAsignatura.add(asingnatura);

			}
		} else {
			System.out.println("No se ha encontrado curso");
		}

		return listaAsignatura;
	}

	// Creamos una clase alumno en la base de datos
	public Alumno insertarAlumno(String nombre, String curso) {
		// !ATENCION¡ Pendiente crear estructura de control para duplicidad
		Alumno nuevoAlumno = new Alumno();
		
		nuevoAlumno.setNombre(nombre);
		nuevoAlumno.setCurso(curso);
		List<String> cursoAlumno = getAsignaturaByCurso(curso);
		
		nuevoAlumno.setAsignaturas(cursoAlumno);

		repo.crearAlumno(nuevoAlumno);
		// Devuelve la clase entera, en BBDD listaAsignaturas = null
		return nuevoAlumno;
	}
	// Obtenemos una lista de clase alumno de la base de datos
	public List<Alumno> mostrarAlumno() {
		// !ATENCION¡ Pendiente guarda la lista
		// Valor al insertar en BBDD = null
		return repo.mostrarAlumno();
	}
	
	public List<String> mostrarAsignaturas() {
		return repo.mostrarAsignaturas();
	}
	

}
