package com.evaluacion.acceso_datos.service;
/*
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.FichaPregunta;
import com.evaluacion.acceso_datos.entities.FichaRespuesta;
import com.evaluacion.acceso_datos.entities.Pregunta;
import com.evaluacion.acceso_datos.entities.Respuesta;
import com.evaluacion.acceso_datos.repository.ApiRepository;
import com.evaluacion.acceso_datos.repository.RepositoryObjectDB;

@Service
public class ServiceObjectDBImpl implements ServiceObjectDB {

	@Autowired
	protected ApiRepository api;

	@Autowired
	protected RepositoryObjectDB repo;

	public Alumno crearAlumno(String nombre, String curso) {
		Alumno alumno = new Alumno(nombre, curso);
		return alumno;
	}

	public List<FichaPregunta> obtenerTest() {
		List<FichaPregunta> listaPreguntas = new ArrayList<>();

		Pregunta[] test = api.obtenerJSON();
		//Mapper mapeoDatos = new Mapper();
		List<FichaRespuesta> listaRespuesta = new ArrayList<>();
		for (Pregunta pregunta : test) {
			FichaPregunta fichaPregunta = new FichaPregunta();
			
			fichaPregunta.setTexto(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
					.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
			fichaPregunta.setEsSeleccion(pregunta.isEsSeleccion());
			listaPreguntas.add(fichaPregunta);
			//fichaPregunta = mapeoDatos.preguntaToFichaPregunta(pregunta);

			for (Respuesta respuesta : pregunta.getListaRespuesta()) {
				FichaRespuesta fichaRespuesta = new FichaRespuesta();
				fichaRespuesta.setEsCorrecta(respuesta.isEsCorrecta());
				*/
	/*			fichaRespuesta.setRespuesta(respuesta.getRespuesta().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
						.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–")););*/
				//fichaRespuesta = mapeoDatos.respuestaToFichaRespuesta(respuesta);
	//			listaRespuesta.add(fichaRespuesta);

			//	repo.crearRespuesta(fichaRespuesta);
		/*	}
			fichaPregunta.setListaRespuesta(listaRespuesta);

			listaPreguntas.add(fichaPregunta);

		}

		return listaPreguntas;
	}


	/*
	 * public String crearPersona() {
	 * 
	 * Pregunta[] listaPreguntas = api.obtenerJSON();
	 * 
	 * for(Pregunta pregunta: listaPreguntas) {
	 * System.out.println(pregunta.getTexto());
	 * 
	 * }
	 * 
	 * 
	 * return "OK"; }
	 */
/*
	public Pregunta[] obtenerJSON() {
		Pregunta[] listaPreguntas = api.obtenerJSON();
		String prueba = "ￂ﾿Quￃﾩ tipo de trama de administraciￃﾳn puede emitir regularmente un AP?";
	//	Mapper mapeoDatos = new Mapper();
		FichaPregunta fichaPregunta = new FichaPregunta();
		FichaRespuesta fichaRespuesta = new FichaRespuesta();
		List<FichaPregunta> lista = new ArrayList<>();

		for (Pregunta pregunta : listaPreguntas) {
			fichaPregunta = new FichaPregunta();
			fichaPregunta.setTexto(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
					.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
			pregunta.setTexto(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
					.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
			// fichaPregunta = mapeoDatos.preguntaToFichaPregunta(pregunta);
			for (Respuesta respuesta : pregunta.getListaRespuesta()) {
				fichaRespuesta.setRespuesta(
						respuesta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿").replace("ￃﾳ", "ó")
								.replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
				respuesta.setTexto(
						respuesta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿").replace("ￃﾳ", "ó")
								.replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
				// fichaRespuesta = mapeoDatos.respuestaToFichaRespuesta(respuesta);
				fichaPregunta.setRespuesta(fichaRespuesta);
			}
			lista.add(fichaPregunta);

			// Cambiar caracteres

			// repo.crearPersona(fichaPregunta);

		} // System.out.println(lista.get(0).getListaRespuesta());
		// System.out.println("Preguntas: " + listaPreguntas);
		return listaPreguntas;
	}

}
*/