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
import com.evaluacion.acceso_datos.entities.Curso;
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
	Map<String, List<String>> getAsignaturaByCurso(@RequestParam String curso){
		return servicio.getAsignaturaByCurso(curso);
	};
	
	@ResponseBody
	@PostMapping("/crear-alumno")
	public Alumno insertarAlumno(@RequestParam String nombre, @RequestParam String curso) {
		return servicio.insertarAlumno(nombre, curso);
	}
	@ResponseBody
	@PostMapping("/crear-curso")
	public Curso insertarCurso(@RequestParam String curso) {
		return servicio.crearCurso(curso);
	}
}
	
	/*
	@ResponseBody
	@GetMapping("/crear-alumno")
    public String guardarAlumno(@RequestParam String nombre, @RequestParam String curso) {
    	
    	Alumno alumno = new Alumno(nombre, curso);
    	
        return servicio.guardarAlumno(alumno);
    }
    
    public List<Alumno> obtenerTodosLosAlumnos() {
        return servicio.obtenerTodosLosAlumnos();
    }
    */
    
    /*
    public String guardarAsignatura(@RequestParam String curso, @RequestParam String asignatura) {
    	Asignatura asignaturaGuardado = repoAsignatura.save(asignatura);
        String id = Long.toString(asignaturaGuardado.getId());
        String idAsignaturaGuardado = String.valueOf(asignaturaGuardado.getId());
        return id +" Alumno creado con id: " + idAsignaturaGuardado;
    }
    
    public List<Asignatura> obtenerAsignaturasDeAlumnoDAM(Long idAlumno) {
        // Suponiendo que el repositorio AlumnoRepository está disponible
        Alumno alumno = repoAlumno.findById(idAlumno).orElse(null);
        if (alumno == null) {
            // Manejar el caso en el que no se encuentra el alumno
            return null;
        }
        
        String cursoAlumno = alumno.getCurso();
        
        // Suponiendo que el nombre del curso DAM es "DAM"
        if (!cursoAlumno.equals("DAM")) {
            // Manejar el caso en el que el alumno no está estudiando DAM
            return null;
        }

        return repoAsignatura.findByCurso(cursoAlumno);
        
    }
    */
	/*
	@Autowired
	protected ServiceObjectDB servicio;
//	protected ApiRepositorio servicio;	
	@ResponseBody
	@GetMapping("prueba")
	//public String obtenerTest() {
	//public List<FichaPregunta> obtenerTest() {
	public String prueba() {
		return "Conexion establecida con exito";
	}
	
	@ResponseBody
	@GetMapping("obtener-json")
	public Pregunta[] obtenerJSON() {
	//public List<FichaPregunta> obtenerTest() {
	//public FichaPregunta obtenerTest() {
		return servicio.obtenerJSON();
	}
	
	@ResponseBody
	@GetMapping("obtener-test")
	 public List <FichaPregunta> obtenerTest() {
			return servicio.obtenerTest();
		
	 }
	 
}*/