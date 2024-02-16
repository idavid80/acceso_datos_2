package com.evaluacion.acceso_datos.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.acceso_datos.collection.Curso;
import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.repository.ApiProyecto;
import com.evaluacion.acceso_datos.repository.EstudianteRepository;


@Service
public class ServiceMongoDBImpl implements ServiceMongoDB{
	
	@Autowired
	private EstudianteRepository estudianteRepo;

    
    protected ApiProyecto apiObjectDB;
    /*
    public List<Alumno> pruebas() {
		return apiObjectDB.mostrarAlumno();

    }
    */
    

    public List<Estudiante> crearEstudiante(List<Alumno> listaAlumnos) {
    	
    	//List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();
    	Estudiante estudiante = new Estudiante();
    	List<Estudiante> listaEstudiante = new ArrayList<>(); 
    	for(Alumno alumno: listaAlumnos) {
    		
    		estudiante.setNombre(alumno.getNombre());

    		
    		Curso curso = new Curso();
    		
    		curso.setNombreCurso(alumno.getCurso());
    		curso.setAsignaturas(alumno.getAsignaturas());
    		
    		estudiante.setCurso(curso);
    		estudianteRepo.save(estudiante);
    	}
    	
    	
        return listaEstudiante;
	}
    
    public List<String> listaCursoDB(){
    	List<Estudiante>  estudiantesDB = estudianteRepo.findAll();
		List<String> listaCursos = new ArrayList<>();
		for(int i = 0; i < estudiantesDB.size();i++) {
			
			String curso = estudiantesDB.get(i).getCurso().getNombreCurso();
			
			listaCursos.add(curso);
			
			
		}
		
		// Metodo para eliminar duplicidad en Arrays
		HashSet<String> conjuntoSinDuplicados = new HashSet<>(listaCursos);		
		listaCursos.clear();
		listaCursos.addAll(conjuntoSinDuplicados); 
		
		return listaCursos;

    }
    public String crearListaByCurso(Map<String, List<String>> hashMap) {
    	Estudiante estudiante = new Estudiante();
		Curso curso = new Curso();
		int id = 0;
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
        	
        	curso.setNombreCurso(entry.getKey());
        	List<String> listaAsignatura = new ArrayList<>();
            for (String asignatura : entry.getValue()) {
            	listaAsignatura.add(asignatura);
            }
            curso.setAsignaturas(listaAsignatura);
            curso.setIdCurso(id);
            
            estudiante.setCurso(curso);
            estudianteRepo.save(estudiante);
            id++;
        }
        
        
        
		return "OK";
    	
    	
    }
	
    /*
    public String crearEstudiante(String nombre, String curso, String id_test, Integer nota) {
    	Estudiante estudiante = new Estudiante(nombre, curso);
    	Calificacion calificaciones = new Calificacion(id_test, nota);
    	estudiante.setCalificacion(calificaciones);
    	

		Curso curso = new Curso();
		curso.setNombreCurso("1 ESO");
		curso.setAsignaturas(Arrays.asList("Matemáticas", "Lenguaje"));

		estudiante.setCurso(curso);

		List<Calificacion> calificaciones = new ArrayList<>();
		Calificacion calificacion1 = new Calificacion();
		calificacion1.setIdTest(54);
		calificacion1.setCurso("1 ESO");
		calificacion1.setAsignatura("Matemáticas");
		calificacion1.setNota(6);
		calificaciones.add(calificacion1);

		Calificacion calificacion2 = new Calificacion();
		calificacion2.setIdTest(58);
		calificacion2.setCurso("1 ESO");
		calificacion2.setAsignatura("Lenguaje");
		calificacion2.setNota(4);
		calificaciones.add(calificacion2);

		estudiante.setCalificaciones(calificaciones);
		
		estudianteRepo.save(estudiante);
		return "Guardado"; 
    }
	
*/


}
