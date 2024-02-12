package com.evaluacion.acceso_datos.entities;

import javax.persistence.Entity;

@Entity
public class Respuesta {
	
	private String respuesta;
    private boolean esCorrecta;
    
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public boolean isEsCorrecta() {
		return esCorrecta;
	}
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}
    


}
