package com.evaluacion.acceso_datos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;

@Repository
public class RepositoryObjectDB {

	protected EntityManagerFactory emf;
	protected EntityManager em;

	protected void conectar() {

		emf = Persistence.createEntityManagerFactory("db/prueba2.odb");
		em = emf.createEntityManager();
	}

	protected void cerrar() {
		em.close();
		emf.close();
	}

	public Asignatura crearAsignatura(String asignatura, String curso) {
		conectar();

		em.getTransaction().begin();

		Asignatura nuevaAsignatura = new Asignatura();
		nuevaAsignatura.setAsignatura(asignatura);
		nuevaAsignatura.setCurso(curso);
		em.persist(nuevaAsignatura);

		em.getTransaction().commit();

		em.close();
		return nuevaAsignatura;
	}
	public List<Asignatura> mostrarAsignatura() {
		conectar();

		TypedQuery<Asignatura> query = em.createQuery("SELECT a FROM Asignatura a", Asignatura.class);
		List<Asignatura> results = query.getResultList();

		cerrar();
		return results;
	}

	public Alumno crearAlumno(Alumno alumno) {
		conectar();

		em.getTransaction().begin();

		Alumno nuevoAlumno = new Alumno();
		nuevoAlumno.setNombre(alumno.getNombre());
		nuevoAlumno.setCurso(alumno.getCurso());
		
		// !ATENCION¡ No genera bien la lista de asignaturas
		nuevoAlumno.setAsignaturas(alumno.getAsignaturas());

		em.persist(nuevoAlumno);

		em.getTransaction().commit();

		em.close();
		return nuevoAlumno;
	}


	public List<Alumno> mostrarAlumno() {

		conectar();

		TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
		List<Alumno> results = query.getResultList();

		cerrar();
		return results;

	}

}
