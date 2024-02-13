package com.evaluacion.acceso_datos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.ficheros.servicios.Fichero;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.entities.Curso;
import com.evaluacion.acceso_datos.repository.RepositoryObjectDB;

@Service
public class ServiceObjectDBImpl implements ServiceObjectDB {

	@Autowired
	protected RepositoryObjectDB repo;

	public Asignatura crearAsignatura(String asignatura, String curso) {
		return repo.crearAsignatura(asignatura, curso);
	}

	public List<Asignatura> mostrarAsignatura() {
		return repo.mostrarAsignatura();
	}

	public List<Map<String, String>> hashMapCurso() {
		// Set para almacenar elementos únicos
		// HashMap<String, List<Asignatura>> hashAsignatura = new HashMap<>();
		List<Asignatura> listaAsignatura = repo.mostrarAsignatura();
		List<Map<String, String>> hashAsignatura = new ArrayList<>();
		for (Asignatura asignatura : listaAsignatura) {
			hashAsignatura.add(Map.of("asignatura", asignatura.getAsignatura(), "curso", asignatura.getCurso()));
		}
		return hashAsignatura;
	}

	public Map<String, List<String>> getAllAsignaturaByCurso() {
		List<Map<String, String>> listaCursos = hashMapCurso();
		Map<String, List<String>> asignaturasPorCurso = new HashMap<>();
		for (Map<String, String> asignatura : listaCursos) {
			// Obtenermos los valores por las claves curso y asignatura
			String curso = asignatura.get("curso");
			String asignaturaNombre = asignatura.get("asignatura");
			//insertamos como clave los valores de curso y añadimos en una lista los valores de asignaturas
			asignaturasPorCurso.putIfAbsent(curso, new ArrayList<>());
			asignaturasPorCurso.get(curso).add(asignaturaNombre);
		}
		return asignaturasPorCurso;
	}
	
	public Map<String, List<String>> getAsignaturaByCurso(String curso) {
		List<Map<String, String>> lista = hashMapCurso();
		Map<String, List<String>> asignaturaByCurso = new HashMap<>();
        for (Map<String, String> hashMap : lista) {
        	if (hashMap.containsKey(curso)) {
        		String valor = hashMap.get(curso);
        		asignaturaByCurso.putIfAbsent(curso, new ArrayList<>());
        		asignaturaByCurso.get(curso).add(valor);
            }
        	else {
        		System.out.println("No se ha encontrado curso");
        	}
        }
			return asignaturaByCurso;
	}
	
	public Alumno insertarAlumno(String nombre, String curso) {
		Alumno nuevoAlumno = new Alumno();
		Map<String, List<String>> cursoAlumno = getAsignaturaByCurso(curso);
		nuevoAlumno.setNombre(nombre);
		nuevoAlumno.setAsignaturasPorCurso(cursoAlumno);
		repo.crearAlumno(nuevoAlumno);
		return nuevoAlumno;
	}
	
    public Curso crearCurso(String curso) {
    	Curso nuevoCurso = new Curso();
    	Map<String, List<String>> hashMap = getAsignaturaByCurso(curso) ;
    	List<String> valores = new ArrayList<>();
		for (String i : hashMap.keySet()) {
			System.out.println("hash: " + i);
			if (hashMap.get(i).equals(curso)) {
			nuevoCurso.setNombre(i);
			valores	 = hashMap.get(i);
			}
		}
    	nuevoCurso.setListaAsignaturas(valores);
    	repo.crearCurso(nuevoCurso);
    	
    	return nuevoCurso;
    }
}
