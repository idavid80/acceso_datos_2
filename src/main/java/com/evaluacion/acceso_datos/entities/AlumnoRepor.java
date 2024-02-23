package com.evaluacion.acceso_datos.entities;

import java.util.ArrayList;
import java.util.List;


public class AlumnoRepor {
	

	private Long id;
	private String nombre;

	private String curso;

	List<String> asignaturas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<String> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<String> asignaturas) {
		this.asignaturas = asignaturas;
	}
}
