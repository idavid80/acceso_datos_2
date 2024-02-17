package com.evaluacion.acceso_datos.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "estudiante")
public class Estudiante {

	@Id
	private String idEstudiante;

	private String nombre;

	@DocumentReference
	private Curso curso;

	private Calificacion calificacion;

	String IdCurso;

	public Estudiante() {
	}

	public Estudiante(String nombre) {
		super();
		this.nombre = nombre;

	}

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public String getIdCurso() {
		return IdCurso;
	}

	public void setIdCurso(String idCurso) {
		IdCurso = idCurso;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

}