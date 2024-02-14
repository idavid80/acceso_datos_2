package com.evaluacion.acceso_datos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Asignatura {
	/*.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

	public String getNombre() {
		return nombre;
	}

	// set y get
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	*/
	// comentario inicio
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String asignatura;
	    private String curso;
/*
	    @ManyToOne
	    @JoinColumn(name = "curso_id")
	    private Curso curso;

	    // comentario final
*/
		public String getAsignatura() {
			return asignatura;
		}
		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
	
	
	
   
    
}
