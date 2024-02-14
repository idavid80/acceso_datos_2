package com.evaluacion.acceso_datos.service;

import java.util.List;

import com.evaluacion.acceso_datos.entities.PreguntaTest;


public interface ServiceXML {
	
    public List<PreguntaTest> listado();

    public String insertar();
    
    String insertarPreguta(PreguntaTest pregunta);

}