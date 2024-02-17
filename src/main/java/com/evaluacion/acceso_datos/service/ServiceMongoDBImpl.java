package com.evaluacion.acceso_datos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.acceso_datos.collection.Curso;
import com.evaluacion.acceso_datos.collection.Estudiante;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.repository.EstudianteRepository;
import com.evaluacion.acceso_datos.repository.mongoDB.CursoRepository;

@Service
public class ServiceMongoDBImpl implements ServiceMongoDB {

	@Autowired
	private EstudianteRepository estudianteRepo;

	@Autowired
	private CursoRepository cursoRepo;

	public List<Estudiante> crearEstudiante(List<Alumno> listaAlumnos) {

		// Lista de alumno enciada desde apiObjectDB
		// List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();

		// Inicializamos clasess para el metodo
		Estudiante estudiante = new Estudiante();
		List<Estudiante> listaEstudiante = new ArrayList<>();

		Curso curso = new Curso();

		// Obtenemos Alumnos de la listra de Alumnos de la base de datos ObjectDB
		for (Alumno alumno : listaAlumnos) {
			estudiante = new Estudiante();
			// Insertamos el nombre del alumno
			estudiante.setNombre(alumno.getNombre());

			// Obtenemos el curso de la base de datos de MongoDB
			curso = cursoRepo.findByCurso(alumno.getCurso());

			estudiante.setIdCurso(curso.getIdCurso());

			estudianteRepo.save(estudiante);
		}

		return listaEstudiante;
	}

	public List<Curso> crearCurso(Map<String, List<String>> hashMap) {

		// Obtenemos hashMap desde el metoddo getAllAsignaturaByCurso() de ObjectDB

		// Inicializamos Clases para el metodo
		List<Curso> listaCursos = new ArrayList<>();
		Curso curso = new Curso();
		List<String> listaAsignatura = new ArrayList<>();
		// int id = 0;
		// Mapeamos el hashMap
		for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
			curso = new Curso();
			// Obtenemos el valor de la clave del hashMap (nombreCurso)
			curso.setNombreCurso(entry.getKey());
			listaAsignatura = new ArrayList<>();
			// Iteramos los valores de la lista del hashMap
			for (String asignatura : entry.getValue()) {
				// Añadimos cada valor de la clave del hashMap
				listaAsignatura.add(asignatura);
			}

			curso.setAsignaturas(listaAsignatura);
			// curso.setIdCurso(id);
			listaCursos.add(curso);
			cursoRepo.save(curso);
			// id++;
		}

		return listaCursos;

	}
	
	public Curso getCurso(String id_curso) {
		// Inicializamos Clases
		Curso curso = new Curso();
		// Obtenemos la clase curso con el id_curso
		Optional<Curso> cursoDB = cursoRepo.findById(id_curso);
		
		// obtenemos datos del curso
		curso.setIdCurso(cursoDB.get().getIdCurso());
		curso.setAsignaturas(cursoDB.get().getAsignaturas());
		curso.setNombreCurso(cursoDB.get().getNombreCurso());

		return curso;
		
	}

	public Curso getCursoByEstudiante(String id_estudiante) {
		
		// Obtenemos el estudiante por id de la BBDD
		Optional<Estudiante> estudiante = estudianteRepo.findById(id_estudiante);
		
		// Obtenemos el id del curso de dicho estudiante
		String id_curso = estudiante.get().getIdCurso();

		return getCurso(id_curso);

	}

	public Estudiante getAsignaturaEstudiante(String id_estudiante) {
		
		// Inicializamos clases
		Estudiante estudiante = new Estudiante();
		Curso curso = new Curso();
		
		// Obtenemos el estudiante por id de la BBDD
		Optional<Estudiante> estudianteDB = estudianteRepo.findById(id_estudiante);
		
		// insertamos los datos del estudiante
		estudiante.setIdEstudiante(id_estudiante);
		estudiante.setNombre(estudianteDB.get().getNombre());

		String id_curso = estudianteDB.get().getIdCurso();
		estudiante.setIdCurso(id_curso);
		
		curso = getCurso(id_curso);

		estudiante.setCurso(curso);

		return estudiante;
	}

	public List<Estudiante> getAll() {
		return estudianteRepo.findAll();
	}

}
