package com.evaluacion.acceso_datos.service;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.repository.RepositoryAsignatura;
import com.evaluacion.acceso_datos.repository.RepositoryObject;

public class ServiceObject {

    @Autowired
    private RepositoryObject repoAlumno;
    private RepositoryAsignatura repoAsignatura;

    public String guardarAlumno(Alumno alumno) {
        Alumno alumnoGuardado = repoAlumno.save(alumno);
        String id = Long.toString(alumnoGuardado.getId());
        String idAlumnoGuardado = String.valueOf(alumnoGuardado.getId());
        return id +" Alumno creado con id: " + idAlumnoGuardado;
    }
    
    public List<Alumno> obtenerTodosLosAlumnos() {
        return repoAlumno.findAll();
    }
    
    public String guardarAsignatura(Asignatura asignatura) {
    	
    	String respuesta = "Ya existe esta asignatura";

    	for(Asignatura comprobar: repoAsignatura.findAll()) {
    		if(comprobar.getNombre() != asignatura.getNombre()) {
    	    	Asignatura asignaturaGuardado = repoAsignatura.save(asignatura);
    	        String id = Long.toString(asignaturaGuardado.getId());
    	        String idAsignaturaGuardado = String.valueOf(asignaturaGuardado.getId());
    	        
    	        respuesta =  id +" Alumno creado con id: " + idAsignaturaGuardado;
    		}
    		
    	}
    	return respuesta;
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
    
}
*/