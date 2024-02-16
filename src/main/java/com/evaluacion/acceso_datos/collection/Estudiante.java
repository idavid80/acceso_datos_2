package com.evaluacion.acceso_datos.collection;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "estudiante")
public class Estudiante {
    private String nombre; 
    

	private Curso curso; 

    private Calificacion calificacion;

    public Estudiante() {
    }
	public Estudiante(String nombre) {
		super();
		this.nombre = nombre;

	}
	public String getNombre() {
		return nombre;
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