package com.evaluacion.acceso_datos.repository;
/*

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.FichaPregunta;
import com.evaluacion.acceso_datos.entities.FichaRespuesta;


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


	public String crearPregunta(FichaPregunta pregunta) {

		conectar();
		em.getTransaction().begin();
		em.persist(pregunta);
		em.getTransaction().commit();
		TypedQuery<FichaPregunta> query = em.createQuery("SELECT p FROM FichaPregunta p", FichaPregunta.class);
		List<FichaPregunta> results = query.getResultList();
		for (FichaPregunta p : results) {
			System.out.printf( "Pregunta %s: es %s.", p.getTexto(), p.getEsSeleccion());
		}
		em.close();
		return "OK";
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
*/
