package com.evaluacion.acceso_datos.repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.Pregunta;
import com.evaluacion.acceso_datos.entities.Respuesta;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ApiRepository {

	// Obtener Json de la API Test y devuelve todos los Test en un lista clase Pregunta
	public Pregunta[] obtenerJSON() {

		Pregunta[] lista = null;

		try {
			// Conectamos con la API
			URL url = new URL("http://localhost:7777/obtener-test");
			HttpURLConnection cx = (HttpURLConnection) url.openConnection();
			// Introducimos los datos obtenidos de la API
			InputStream is = cx.getInputStream();
			byte[] arrStream = is.readAllBytes();
			// Inicializamos el json que vamos a obtener de la API
			String json = "";

			// insertamos JSON de la api en nuestra variable
			for (byte tmp : arrStream) {
				json += (char) tmp;
			}
			// System.out.println("Contenido: " + json);
			ObjectMapper objectMapper = new ObjectMapper();
			Pregunta[] preguntas = objectMapper.readValue(json, Pregunta[].class);
			lista = preguntas;

			// Ahora puedes acceder a las preguntas y respuestas
			for (Pregunta pregunta : preguntas) {
				// System.out.println("Pregunta: " + pregunta.getTexto() + " es " +
				// pregunta.getEsSeleccion());
				pregunta.setTexto(
						pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿").replace("ￃﾳ", "ó")
								.replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
				for (Respuesta respuesta : pregunta.listaRespuesta) {
					respuesta.setRespuesta(respuesta.getRespuesta().replace("ￃﾭ", "í").replace("ￃﾩ", "é")
							.replace("ￂ﾿", "¿").replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú")
							.replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	// Api XML para MongoDB
	@Autowired
	protected RepositoryObjectDB apiObjectDB;
	
	public List<Alumno> mostrarAlumno() {
		List<Alumno> listaAlumno = apiObjectDB.mostrarAlumno();
		return listaAlumno;
	}
}
