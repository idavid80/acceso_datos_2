package com.evaluacion.acceso_datos.repository.mongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.evaluacion.acceso_datos.collection.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {

	@Query("{ 'nombreCurso' : ?0}")
	public Curso findByCurso(String nombreCurso);

}