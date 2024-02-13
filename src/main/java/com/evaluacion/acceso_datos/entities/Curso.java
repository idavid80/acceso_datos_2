package com.evaluacion.acceso_datos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<String> listaAsignaturas;
	/*
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Alumno> alumnos;
*/

	public String getNombre() {
		return nombre;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<String> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}


	//private List<Asignatura> asignaturas;

}