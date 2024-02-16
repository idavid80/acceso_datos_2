package com.evaluacion.acceso_datos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evaluacion.acceso_datos.entities.Alumno;

@Repository
public class ApiProyecto {
	// Api XML para MongoDB
	@Autowired
	protected RepositoryObjectDB apiObjectDB;
	
	public List<Alumno> mostrarAlumno() {
		List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();

		return listaAlumno;
	}
}
