package com.evaluacion.acceso_datos.service;

import java.util.List;

import com.evaluacion.acceso_datos.entities.PreguntaTest;

public interface ServiceXML {

	public String testXML();

	public List<PreguntaTest> getTestBD();

	public String insertar();

}
