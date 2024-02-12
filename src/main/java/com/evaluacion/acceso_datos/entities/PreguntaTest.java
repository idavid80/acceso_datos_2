package com.evaluacion.acceso_datos.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "test")
public class PreguntaTest {

		
	@XmlAttribute(name="identificador")
	protected int identificador;

	String pregunta;
	boolean esMultiple;
	
	List<RespuestaTest> respuestaTest;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public boolean isEsMultiple() {
		return esMultiple;
	}

	public void setEsMultiple(boolean esMultiple) {
		this.esMultiple = esMultiple;
	}
	
	public void addRespuesta(RespuestaTest respuesta ) {
		respuestaTest.add(respuesta);
		
	}
	
	public void getRespuesta(List<RespuestaTest> lista) {
		for(int i = 0; i < lista.size(); i++ ) {
			lista.get(i);
		}
	}

	public List<RespuestaTest> getRespuestaTest() {
		return respuestaTest;
	}

	public void setRespuestaTest(List<RespuestaTest> respuestaTest) {
		this.respuestaTest = respuestaTest;
	}

	public PreguntaTest(int identificador, String pregunta, boolean esMultiple) {
		super();
		this.identificador = identificador;
		this.pregunta = pregunta;
		this.esMultiple = esMultiple;
	}
	
	
}
