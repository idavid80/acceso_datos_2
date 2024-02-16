package com.evaluacion.acceso_datos.collection;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "estudiante.calificacion")
public class Calificacion {
    
    public String id_test;
    public Integer nota;
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