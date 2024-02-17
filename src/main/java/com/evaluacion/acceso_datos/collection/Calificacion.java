package com.evaluacion.acceso_datos.collection;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "calificacion")
public class Calificacion {

	public String id_test;

	public Integer nota;

	public String id_alumno;

	public String asignatura;

	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date fechaCreacion;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getId_test() {
		return id_test;
	}

	public void setId_test(String id_test) {
		this.id_test = id_test;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Calificacion(String id_test, Integer nota) {
		super();
		this.id_test = id_test;
		this.nota = nota;
	}

	public Calificacion() {
	}

}