package com.evaluacion.acceso_datos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.service.ServiceJasper;
import com.evaluacion.acceso_datos.service.ServiceMongoDB;

@Controller
@RequestMapping("jasper")
public class ControllerJasper {

	@Autowired
	protected ServiceJasper service;
	
	@Autowired
	private ServiceMongoDB baseDatos;
	
	@GetMapping("generar")
	@ResponseBody
	public String generarInforme() {
		List<Estudiante> listaEstudiantes = baseDatos.getAll();
		service.generarInforme(listaEstudiantes);
		return "OK";
	}
}
