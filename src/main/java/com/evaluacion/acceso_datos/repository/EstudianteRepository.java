package com.evaluacion.acceso_datos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.evaluacion.acceso_datos.collection.Estudiante;

	public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
		
	    @Query("{ 'nombre' : ?0 }")
	    public List<Estudiante> findByNombre(String nombre);

	    @Query("{ 'nombreCurso' }")
	    public List<Estudiante> findByCurso(String curso);

	    @Query("{ 'nombre' : ?0, 'calificaciones' : ?1 }")
	    public List<Estudiante> findByCalificaciones(String nombre, String calificaciones);
	    
	    

	}
