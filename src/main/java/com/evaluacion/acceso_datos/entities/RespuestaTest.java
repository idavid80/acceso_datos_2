package com.evaluacion.acceso_datos.entities;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "respuesta")
public class RespuestaTest {

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
