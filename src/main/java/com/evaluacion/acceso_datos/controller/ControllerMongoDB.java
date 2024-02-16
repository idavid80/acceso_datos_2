package com.evaluacion.acceso_datos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evaluacion.acceso_datos.collection.Calificacion;
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
    public List<Estudiante> crearEstudiante() {
		List<Alumno> listaAlumnos = objectAlumno.mostrarAlumno();
		return service.crearEstudiante(listaAlumnos);
    }
	
	@ResponseBody
	@GetMapping("/crear-lista-asignaturas")
    public String crearListaByCurso() {
		
		Map<String, List<String>> hashmap = objectAlumno.getAllAsignaturaByCurso();
				
		return service.crearListaByCurso(hashmap);
    }
	
	@ResponseBody
	@GetMapping("/lista-cursobd")
    public List<String> listaCursoDB() {
		
	//	List<Map<String, String>> hashmap = objectAlumno.hashMapCurso();
				
		return service.listaCursoDB();
    }

	/*
	@ResponseBody
	@GetMapping("/prueba-alumno")
	public List<Alumno> pruebas(){
		return objectAlumno.mostrarAlumno();
	//	return service.pruebas();
	}*/
	/*
	@ResponseBody
	@PutMapping("/crear-estudiante")
    public String crearEstudiante(String nombre, String curso, String id_test, Integer nota) {
		return service.crearEstudiante(nombre, curso, id_test, nota);
    }
	
	@ResponseBody
	@GetMapping("/crear-prueba")
    public List<Alumno> pruebas() {
	//	((List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();
    	return service.pruebas();
    }
    /*
	/*
    public List<Estudiante> crearEstudiante() {
    	
    	List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();
    	Estudiante estudiante = new Estudiante();
    	List<Estudiante> listaEstudiante = new ArrayList<>(); 
    	for(Alumno alumno: listaAlumno) {
    		
    		estudiante.setNombre(alumno.getNombre());
    		estudiante.setCurso(alumno.getCurso());
    		estudiante.setAsignaturas(alumno.getAsignaturas());
    		
    		estudianteRepo.save(estudiante);
    	}
    	
    	
        return listaEstudiante;
	}
    */


}