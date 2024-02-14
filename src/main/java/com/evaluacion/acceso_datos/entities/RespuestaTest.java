package com.evaluacion.acceso_datos.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "respuesta")
public class RespuestaTest {
	
	@XmlAttribute(name="identificador")
	protected int identificador;
	
	
	public int idPregunta;
	
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	String respuesta;
	boolean esCorrecta;
	
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

	public RespuestaTest() {
	}
	
	public RespuestaTest(String respuesta, boolean esCorrecta) {
		super();
		this.respuesta = respuesta;
		this.esCorrecta = esCorrecta;
	}
	
}
