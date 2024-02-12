package com.evaluacion.acceso_datos.entities;
/*
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String curso;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas;

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

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Alumno() {
		
	}
	
	public Alumno(String nombre, String curso, List<Asignatura> asignaturas) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.asignaturas = asignaturas;
	}
	public Alumno(String nombre, String curso) {
		super();
		this.nombre = nombre;
		this.curso = curso;

	}

    
}
*/