package com.evaluacion.acceso_datos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.collection.Curso;
import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.service.ServiceMongoDB;

@Controller
@RequestMapping("/evaluacion/mongo")
public class ControllerMongoDB {

	@Autowired
	private ServiceMongoDB service;

	@Autowired
	private ControllerObjectDB objectAlumno;

	@ResponseBody
	@GetMapping("/prueba")
	public String prueba() {

		return "Controlador MongoDB funcionando";
	}

	@ResponseBody
	@PutMapping("/crear-estudiante")
	public String crearEstudiante() {
		List<Alumno> listaAlumnos = objectAlumno.mostrarAlumno();
		service.crearEstudiante(listaAlumnos);
		return "Lista de estudiantes creada con éxito";
	}

	@ResponseBody
	@GetMapping("/crear-curso")
	public List<Curso> crearCurso() {
		Map<String, List<String>> hashMap = objectAlumno.getAllAsignaturaByCurso();

		return service.crearCurso(hashMap);
	}

	@ResponseBody
	@PostMapping("/asignaturas-estudiante")
	public Estudiante getAsignaturaEstudiante(String id_estudiante) {
		return service.getAsignaturaEstudiante(id_estudiante);
	}

	@ResponseBody
	@GetMapping("/all-estudiante")
	public List<Estudiante> getAll() {
		return service.getAll();
	}

}
