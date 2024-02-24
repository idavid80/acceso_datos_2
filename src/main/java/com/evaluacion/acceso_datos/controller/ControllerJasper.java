package com.evaluacion.acceso_datos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.service.ServiceJasper;

@Controller
@RequestMapping("/jasper")
public class ControllerJasper {

	@Autowired
	private ControllerObjectDB objectAlumno;

	@ResponseBody
	@PostMapping("/prueba")
	public String prueba() {

		return "OK";
	}

	@Autowired
	protected ServiceJasper jasperService;

	@GetMapping("generar")
	@ResponseBody
	public String generarInforme() {
		List<Alumno> listaAlumnos = objectAlumno.mostrarAlumno();

		jasperService.generarInforme(listaAlumnos);
		return "OK";
	}

}