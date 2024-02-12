package com.evaluacion.acceso_datos.repository;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Repository;


import com.evaluacion.acceso_datos.entities.Pregunta;
import com.evaluacion.acceso_datos.entities.Respuesta;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class ApiRepository {

	
/*
@Override
	public List<TestConDatosVista> obtenerTestsConDatosVista() {
		WebClient client = WebClient.create();
		
		Mono<TestConDatosVista[]> mono = client
				  .post()
				  .uri(uriBuilder -> uriBuilder
						    .path(getServidor() + Constantes.URL_OBTENER_TESTS_CON_DATOS_VISTA)						    
						    .build())
				  .retrieve()
				  .bodyToMono(TestConDatosVista[].class);
		
		return new ArrayList<TestConDatosVista> (Arrays.asList(mono.block()));
	}
	*/
//	public String obtenerJSON() {
	public Pregunta[] obtenerJSON(){
		
		Pregunta[] lista = null;
		
		try {
		//Conectamos con la API	
		URL url = new URL("http://localhost:7777/obtener-test");
		HttpURLConnection cx = (HttpURLConnection) url.openConnection();
		// Introducimos los datos obtenidos de la API 
		InputStream is = cx.getInputStream();
		byte[] arrStream = is.readAllBytes();
		//Inicializamos el json que vamos a obtener de la API
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
			//System.out.println("Pregunta: " + pregunta.getTexto() + " es " + pregunta.getEsSeleccion());
			pregunta.setTexto(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
					.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
			for (Respuesta respuesta : pregunta.listaRespuesta) {
				respuesta.setRespuesta(respuesta.getRespuesta().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿", "¿")
						.replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
				}
		
		}
		}catch (IOException e) {
			 e.printStackTrace(); }
		return lista;
	}
		/*
		 * try { // Obtener JSON desde la URL // String jsonUrl =
		 * "http://localhost:7777/obtener-test"; URL url = new
		 * URL("http://localhost:7777/obtener-test"); HttpURLConnection cx =
		 * (HttpURLConnection) url.openConnection();
		 * 
		 * InputStream is = cx.getInputStream();
		 * 
		 * byte[] arrStream = is.readAllBytes();
		 * 
		 * String contenido = "";
		 * 
		 * for(byte tmp: arrStream) {
		 * 
		 * contenido += (char)tmp; } System.out.println("Contenido: " + contenido);
		 */
		// System.out.println("Tamaño json: " + contenido.length());
		// JSONObject data = new JSONObject(contenido);
		// JSONArray json = new JSONArray(contenido);
		// System.out.println("Array: " + json);

		/*
		 * for(Object obj: json) { System.out.println("Array: " + json); }
		 */

		/*
		 * String jsonResponse = obtenerJSONDesdeURL(jsonUrl);
		 * System.out.println("Objeto Persona:" + jsonResponse.indexOf(1));
		 * 
		 * // Convertir JSON a objeto Java ObjectMapper objectMapper = new
		 * ObjectMapper(); pregunta = objectMapper.readValue(jsonResponse,
		 * FichaPregunta.class);
		 * 
		 * // Imprimir objeto Java System.out.println("Objeto Persona:" +
		 * jsonResponse.length()); System.out.println("Pregunta: " +
		 * pregunta.getTexto()); System.out.println("esMultiple: " +
		 * pregunta.getEsSeleccion());
		 * 
		 * }catch(
		 * 
		 * IOException e) { // catch (IOException | JSONException e) {
		 * e.printStackTrace(); }
		 */
		// return "OK";

	}
/*
	private static String obtenerJSONDesdeURL(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		connection.disconnect();

		return response.toString();
	}
}*/

/*
 * public static String peticionHttpGet(String urlParaVisitar) {
 * 
 * 
 * URL url3 = new URL("http://localhost:8080/obtener-test");
 * 
 * 
 * try (InputStream is = url3.openStream(); JsonReader rdr =
 * Json.createReader(is)) {
 * 
 * JsonObject obj = rdr.readObject();
 * 
 * JsonObject body = obj.getJsonObject("test");
 * 
 * System.out.println(body); } catch(Exception e) { e.printStackTrace(); }
 * return "OK"; }
 */

/*
 * // Esto es lo que vamos a devolver StringBuilder resultado = new
 * StringBuilder(); // Crear un objeto de tipo URL URL url = new
 * URL(urlParaVisitar);
 * 
 * // Abrir la conexión e indicar que será de tipo GET HttpURLConnection
 * conexion = (HttpURLConnection) url.openConnection();
 * conexion.setRequestMethod("GET");
 * 
 * // Búferes para leer BufferedReader rd = new BufferedReader(new
 * InputStreamReader(conexion.getInputStream())); String linea;
 * 
 * 
 * // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
 * while ((linea = rd.readLine()) != null) { resultado.append(linea); } //
 * Cerrar el BufferedReader rd.close(); // Regresar resultado, pero como cadena,
 * no como StringBuilder return resultado.toString(); }
 */