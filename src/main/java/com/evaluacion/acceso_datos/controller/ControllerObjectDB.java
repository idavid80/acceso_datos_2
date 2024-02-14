package com.evaluacion.acceso_datos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.service.ServiceObjectDB;


@Controller
@RequestMapping("/evaluacion")
public class ControllerObjectDB {

	@Autowired
	protected ServiceObjectDB servicio;
	//protected ServiceObject servicio;
	
	@ResponseBody
	@GetMapping("/crear-asignatura")
    public Asignatura crearAsignatura(@RequestParam String asignatura, @RequestParam String curso) {
    		
        return servicio.crearAsignatura(asignatura, curso);
	}
	
	@ResponseBody
	@GetMapping("/mostrar-asignatura")
	public List<Asignatura> mostrarAsignatura(){
		return servicio.mostrarAsignatura();
	}
	
	@ResponseBody
	@GetMapping("/mostrar-hashmap")
	List<Map<String, String>> hashMapCurso(){
		return servicio.hashMapCurso();
	}
	
	@ResponseBody
	@GetMapping("/mostrar-todas-asignaturas-cursos")
	Map<String, List<String>> getAllAsignaturaByCurso(){
		return servicio.getAllAsignaturaByCurso();
	};

	@ResponseBody
	@GetMapping("/mostrar-asignaturas-cursos")
	List<String> getAsignaturaByCurso(@RequestParam String curso){
		return servicio.getAsignaturaByCurso(curso);
	};

	@ResponseBody
	@PostMapping("/crear-alumno")
	public Alumno insertarAlumno(@RequestParam String nombre, @RequestParam String curso) {
		return servicio.insertarAlumno(nombre, curso);
	}
	
	@ResponseBody
	@PostMapping("/mostrar-alumno")
	public List<Alumno> mostrarAlumno(){
		return servicio.mostrarAlumno();
	}

}
	