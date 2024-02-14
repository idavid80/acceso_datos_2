package com.evaluacion.acceso_datos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;

import com.evaluacion.acceso_datos.entities.Pregunta;
import com.evaluacion.acceso_datos.entities.PreguntaTest;
import com.evaluacion.acceso_datos.entities.Respuesta;
import com.evaluacion.acceso_datos.entities.RespuestaTest;
import com.evaluacion.acceso_datos.repository.ApiRepository;
import com.evaluacion.acceso_datos.repository.RepositoryXML;

@Service
public class ServiceXMLImpl implements ServiceXML {
	/*
	 * // sugerencia Guillamon private static String URI =
	 * "xmldb:exist://localhost:8080/exist/xmlrpc";
	 * 
	 * private XPathQueryService obtenerServicioXPath() throws Exception { String
	 * driver = "org.exist.xmldb.DatabaseImpl"; //Driver Class cl =
	 * Class.forName(driver);//Cargar el driver Database database = (Database)
	 * cl.newInstance(); //Instancia de la BD
	 * database.setProperty("create-database", "true");
	 * DatabaseManager.registerDatabase(database); //Registrar la BD //Accedemos a
	 * la colección Collection col =DatabaseManager.getCollection(
	 * "xmldb:exist://localhost:8080/exist/xmlrpc/db/", "admin", "");
	 * 
	 * XPathQueryService service =(XPathQueryService)
	 * col.getService("XPathQueryService", "1.0"); service.setProperty("pretty",
	 * "true"); service.setProperty("encoding", "ISO-8859-1");
	 * 
	 * return service; } // Fin sugerencia Guillamon
	 * 
	 */
	@Autowired
	protected ApiRepository api;
	@Autowired
	protected RepositoryXML repo;

	public Pregunta[] getApi() {
		// public List<Test> getApi() {
		Pregunta[] listaPreguntas = api.obtenerJSON();
		System.out.println(listaPreguntas);
		// String prueba = "ￂ﾿Quￃﾩ tipo de trama de administraciￃﾳn puede emitir
		// regularmente un AP?";
		return listaPreguntas;
		/*
		 * // Mapper mapeoDatos = new Mapper(); Test preguntaTest = new Test();
		 * RespuestaTest respuestaTest = new RespuestaTest(); List<Test> lista = new
		 * ArrayList<>(); List<RespuestaTest> listaRespuesta = new ArrayList<>(); for
		 * (Pregunta pregunta : listaPreguntas) { preguntaTest = new Test();
		 * preguntaTest.setPregunta(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ",
		 * "é").replace("ￂ﾿", "¿") .replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ",
		 * "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–"));
		 * pregunta.setTexto(pregunta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ",
		 * "é").replace("ￂ﾿", "¿") .replace("ￃﾳ", "ó").replace("ￃﾡ", "á").replace("ￃﾺ",
		 * "ú").replace("ￃﾱ", "ñ").replace("￢ﾀﾓ", "–")); // fichaPregunta =
		 * mapeoDatos.preguntaToFichaPregunta(pregunta); for (Respuesta respuesta :
		 * pregunta.getListaRespuesta()) { respuestaTest.setRespuesta(
		 * respuesta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿",
		 * "¿").replace("ￃﾳ", "ó") .replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ",
		 * "ñ").replace("￢ﾀﾓ", "–")); respuesta.setTexto(
		 * respuesta.getTexto().replace("ￃﾭ", "í").replace("ￃﾩ", "é").replace("ￂ﾿",
		 * "¿").replace("ￃﾳ", "ó") .replace("ￃﾡ", "á").replace("ￃﾺ", "ú").replace("ￃﾱ",
		 * "ñ").replace("￢ﾀﾓ", "–")); // fichaRespuesta =
		 * mapeoDatos.respuestaToFichaRespuesta(respuesta);
		 * listaRespuesta.add(respuestaTest);
		 * 
		 * } preguntaTest.setRespuestaTest(listaRespuesta);
		 * System.out.println("listaRespuesta: " + preguntaTest.getRespuestaTest());
		 * lista.add(preguntaTest);
		 * 
		 * // Cambiar caracteres
		 * 
		 * // repo.crearPersona(fichaPregunta);
		 * 
		 * } // System.out.println(lista.get(0).getListaRespuesta()); //
		 * System.out.println("Preguntas: " + listaPreguntas); return lista;
		 */
	}

	public List<RespuestaTest> getRespuestaTestFromApi() {

		Pregunta[] listaPreguntasApi = api.obtenerJSON();
		// List<PreguntaTest> testFromApi = new ArrayList<>();
		List<RespuestaTest> getListaRespuesta = new ArrayList<>();
		RespuestaTest getRespuesta = new RespuestaTest();
		int id = 0;
		for (Pregunta pregunta : listaPreguntasApi) {
			id++;
			// PreguntaTest getPregunta = new PreguntaTest(id, pregunta.getTexto(),
			// pregunta.isEsSeleccion());
			// testFromApi.add(getPregunta);

			getListaRespuesta = new ArrayList<>();
			for (Respuesta respuesta : pregunta.listaRespuesta) {
				System.out.println("Respuesta" + respuesta.getRespuesta());
				getRespuesta.setRespuesta(respuesta.getRespuesta());
				getRespuesta.setIdPregunta(id);
				getRespuesta.setEsCorrecta(respuesta.isEsCorrecta());

				getListaRespuesta.add(getRespuesta);

			}

		}

		return getListaRespuesta;
	}

	public List<PreguntaTest> getTestFromApi() {

		Pregunta[] listaPreguntasApi = api.obtenerJSON();
		List<PreguntaTest> testFromApi = new ArrayList<>();
		int id = 0;
		for (Pregunta pregunta : listaPreguntasApi) {
			id++;
			PreguntaTest getPregunta = new PreguntaTest(id, pregunta.getTexto(), pregunta.isEsSeleccion());
			testFromApi.add(getPregunta);

			for (Respuesta respuesta : pregunta.listaRespuesta) {
				RespuestaTest getRespuesta = new RespuestaTest(respuesta.getRespuesta(), respuesta.isEsCorrecta());
						getRespuesta.setIdPregunta(id);

				getPregunta.addRespuesta(getRespuesta);
			}


		}

		return testFromApi;
	}

	@Override
	public List<PreguntaTest> listadoTest() {

		List<PreguntaTest> test = new ArrayList<>();
		try {
			XPathQueryService service = repo.obtenerServicioXPath();

			// Consulta a lanzar
			// ResourceSet result = service.query("for $b in
			// doc('Documentos/Prueba1')//documento return $b");
			// String query = "doc('Documentos/vino_xml')/vinos/vino";
			String query2 = "doc('Documentos/test1.xml')/xml/documento/test";

			// XPathQueryService service = obtenerServicioXPath();
			ResourceSet result = service.query(query2);
			result = repo.queryDB(query2);
			

			ResourceIterator i = result.getIterator();
			while (i.hasMoreResources()) { // Procesamos el resultado
				Resource r = i.nextResource();
				String xml = (String) r.getContent();
				PreguntaTest documento = repo.obtenerDocumento(xml);

				test.add(documento);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return test;
	}

	public String insertarPreguta(PreguntaTest pregunta) {
		String etiqueta = "<pregunta es_multiple=\"" + pregunta.isEsMultiple() + "\">" + pregunta.getPregunta();

		return etiqueta;
	}

	public String insertarRespuesta(RespuestaTest respuesta, int idPregunta) {
		String etiqueta = "<respuesta id_pregunta=\"" + idPregunta + "\">" + respuesta.getRespuesta() + "<es_correcta>"
				+ respuesta.isEsCorrecta() + "</es_correcta></respuesta>";
		return etiqueta;
	}

	/*
	 * public String insertarCierrePregunta(RespuestaTest respuesta) { String
	 * etiqueta = "</pregunta>"; return etiqueta; } public String
	 * insertarPregutaRespuestas(PreguntaTest pregunta) { String documento =
	 * "<test id=\"" + pregunta.getIdentificador() + "\">"; documento +=
	 * insertarPreguta(pregunta);
	 * 
	 * 
	 * int i = 1;
	 * 
	 * 
	 * while(i != pregunta.getIdentificador()) { documento +=
	 * insertarRespuesta(pregunta.getRespuestaTest().get(i-1),
	 * pregunta.getIdentificador()); i++; }
	 * 
	 * for(RespuestaTest respuesta: pregunta.getRespuestaTest()) {
	 * 
	 * documento += insertarRespuesta(respuesta, pregunta.getIdentificador()); }
	 * documento += "</pregunta></test>";
	 * 
	 * //System.out.println(documento); return documento; }
	 */
	public String insertarTest(List<PreguntaTest> listaPregunta) {
		String documento = "";

		for (PreguntaTest pregunta : listaPregunta) {

			documento += "<test id=\"" + pregunta.getIdentificador() + "\">";
			documento += insertarPreguta(pregunta);

			for (RespuestaTest respuesta : pregunta.respuestaTest) {
				documento += insertarRespuesta(respuesta, pregunta.getIdentificador());
			}
			documento += "</pregunta></test>";
		}
		return documento;
	}
	/*
	 * public String testXML() { List<PreguntaTest> listaPregunta =
	 * getTestFromApi();
	 * 
	 * return insertarTest(listaPregunta); }
	 */

	public String testXML() {
		List<PreguntaTest> listaPregunta = getTestFromApi();
		List<RespuestaTest> listaRespuesta = getRespuestaTestFromApi();
		String documento = "";

		for (PreguntaTest pregunta : listaPregunta) {
			
			documento += "<test id=\"" + pregunta.getIdentificador() + "\">";
			documento += insertarPreguta(pregunta);
			
			for (RespuestaTest respuesta : listaRespuesta) {
				documento += insertarRespuesta(respuesta, pregunta.getIdentificador());
			}
			documento += "</pregunta></test>";
		}
		return documento;
	}

	@Override
	public String insertar() {

		try {
			// String sQuery = "update insert <documento id=\"6\"><nombre>Prueba
			// 6</nombre></documento>" +
			// " into doc('Documentos/test1.xml')/xml";

			String query = "update insert " + testXML() + " into doc('Documentos/test1.xml')/xml";

			XPathQueryService service = repo.obtenerServicioXPath();
			service.query(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}

}
