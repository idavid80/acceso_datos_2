package com.evaluacion.acceso_datos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Pregunta {

    private String texto;
    private boolean esSeleccion;
	public List<Respuesta> listaRespuesta = new ArrayList<>();
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isEsSeleccion() {
		return esSeleccion;
	}
	public void setEsSeleccion(boolean esSeleccion) {
		this.esSeleccion = esSeleccion;
	}
	
	public void agregarRespuesta(Respuesta respuesta ) {
		listaRespuesta.add(respuesta);
		
	}
	
	public void obtenerRespuesta(List<Respuesta> lista) {
		for(int i = 0; i < lista.size(); i++ ) {
			lista.get(i);
		}
		
	}
	
    
}
