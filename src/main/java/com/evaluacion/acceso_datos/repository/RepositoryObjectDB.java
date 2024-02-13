package com.evaluacion.acceso_datos.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cesur.ficheros.servicios.FichaPregunta;
import com.cesur.ficheros.servicios.FichaRespuesta;
import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Asignatura;
import com.evaluacion.acceso_datos.entities.Curso;


@Repository
public class RepositoryObjectDB {
	
	protected EntityManagerFactory emf;
	protected EntityManager em;

	protected void conectar() {

		emf = Persistence.createEntityManagerFactory("db/test.odb");
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
/*
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> results = query.getResultList();
        for (Persona p : results) {
            System.out.println(p.getNombre());
        }
*/
        em.close();
        return nuevaAsignatura;
    }
    
    public Alumno crearAlumno(Alumno alumno) {
        conectar();
        
        em.getTransaction().begin();
        
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombre(alumno.getNombre());
        nuevoAlumno.setAsignaturasPorCurso(alumno.getAsignaturasPorCurso());
        em.persist(nuevoAlumno);

        em.getTransaction().commit();
/*
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> results = query.getResultList();
        for (Persona p : results) {
            System.out.println(p.getNombre());
        }
*/
        em.close();
        return nuevoAlumno;
    }
    
    public Curso crearCurso(Curso curso) {
        conectar();
        
        em.getTransaction().begin();
        
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        nuevoCurso.setListaAsignaturas(curso.getListaAsignaturas());
        em.persist(nuevoCurso);

        em.getTransaction().commit();
/*
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> results = query.getResultList();
        for (Persona p : results) {
            System.out.println(p.getNombre());
        }
*/
        em.close();
        return nuevoCurso;
    }
    

    public List<Asignatura> mostrarAsignatura() {
        conectar();

        TypedQuery<Asignatura> query = em.createQuery("SELECT a FROM Asignatura a", Asignatura.class);
        List<Asignatura> results = query.getResultList();
       
        cerrar();
        return results;
    }
    
    

	public List<FichaPregunta> mostrarPersona() {
		conectar();
		TypedQuery<FichaPregunta> query = em.createQuery("SELECT p FROM FichaPregunta p", FichaPregunta.class);

		List<FichaPregunta> results = query.getResultList();

		for (FichaPregunta p : results) {
			System.out.printf( "Pregunta %s: es %s.", p.getTexto(), p.getEsSeleccion());
		}
		cerrar();
		return results;
	}

	public String obtenerRespuesta(FichaRespuesta respuesta) {

		conectar();
		em.getTransaction().begin();
		em.persist(respuesta);
		em.getTransaction().commit();
		TypedQuery<FichaRespuesta> query = em.createQuery("SELECT * FROM FichaRespuesta where(esCorrecta= True", FichaRespuesta.class);
		List<FichaRespuesta> results = query.getResultList();
		for (FichaRespuesta r : results) {
			System.out.printf( "Respuesta %s: es %s.", r.getRespuesta());
		}
		em.close();
		return "OK";
	}
	public String crearRespuesta(FichaRespuesta respuesta) {

		conectar();
		em.getTransaction().begin();
		em.persist(respuesta);
		em.getTransaction().commit();
		TypedQuery<FichaRespuesta> query = em.createQuery("SELECT r FROM FichaRespuesta r", FichaRespuesta.class);
		List<FichaRespuesta> results = query.getResultList();
		for (FichaRespuesta r : results) {
			System.out.println(r.getRespuesta());
		}
		em.close();
		return "OK";
	}

	public List<FichaRespuesta> mostrarNacionalidad() {
		conectar();
		TypedQuery<FichaRespuesta> query = em.createQuery("SELECT r FROM FichaRespuesta r", FichaRespuesta.class);
		List<FichaRespuesta> results = query.getResultList();
		for (FichaRespuesta r : results) {
			System.out.println(r.getRespuesta());
		}

		cerrar();

		return results;

	}

}

