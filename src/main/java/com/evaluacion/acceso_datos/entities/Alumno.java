package com.evaluacion.acceso_datos.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
    @ManyToOne
    @JoinColumn(name = "curso_id")
	private String curso;
   
    //List<Asignatura> asignaturas = new ArrayList<>();
    /*
	// set y get
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
    */
    
    @ElementCollection
    @CollectionTable(name = "alumno_asignaturas_por_curso")
    @MapKeyColumn(name = "curso")
    @Column(name = "asignaturas")
    private Map<String, List<String>> asignaturasPorCurso;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, List<String>> getAsignaturasPorCurso() {
		return asignaturasPorCurso;
	}

	public void setAsignaturasPorCurso(Map<String, List<String>> asignaturasPorCurso) {
		this.asignaturasPorCurso = asignaturasPorCurso;
	}

    // Constructor, getters y setters
    

    
    
}
