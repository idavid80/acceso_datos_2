package com.evaluacion.acceso_datos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.entities.Pregunta;
import com.evaluacion.acceso_datos.entities.PreguntaTest;
import com.evaluacion.acceso_datos.entities.RespuestaTest;
import com.evaluacion.acceso_datos.service.ServiceXMLImpl;

@Controller
@RequestMapping("/evaluacion")
public class ControllerXML {

    @Autowired
    protected ServiceXMLImpl service;

    @PostMapping("/get-bbdd-test")
    @ResponseBody
    public List<PreguntaTest> getTestBD() {
    	return service.getTestBD();

    }

    @GetMapping("/prueba")
    @ResponseBody
    public String prueba() {
    	return "OK, conectado";

    }
    @PutMapping("/insertar")
    @ResponseBody
    public String insertar() {
        return service.insertar();
    }
    
    @GetMapping("/get-api")
    @ResponseBody
    public Pregunta[] getApi() {
 //   public List<Test> getApi() {
    	return service.getApi();
    }
    
    @PostMapping("/get-test-api")
    @ResponseBody
    public List<PreguntaTest> listadoApi() {
    	return service.getTestFromApi();

    }
    
    @GetMapping("/ver-test-xml")
    @ResponseBody
    public String testXML() {
        return service.testXML();
    }
    
    @GetMapping("/get-respuestas-api")
    @ResponseBody
    public List<RespuestaTest> getListaRespuestaApi() {
        return service.getListaRespuestaApi();
    }
    
    
   
}