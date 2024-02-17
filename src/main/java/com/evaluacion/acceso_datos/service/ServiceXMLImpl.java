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

	@Autowired
	protected ApiRepository api;
	@Autowired
	protected RepositoryXML repo;

	// Obtener lista test desde la API
	public Pregunta[] getApi() {

		Pregunta[] listaPreguntas = api.obtenerJSON();

		return listaPreguntas;
	}

	// Mapea la lista Pregunta de la API a una lista PreguntaTest para BBDD
	public List<PreguntaTest> getTestFromApi() {
		// Inicializamos Clase
		List<PreguntaTest> getTest = new ArrayList<>();

		// Obtenemos los datos de la API
		Pregunta[] listaPreguntasApi = api.obtenerJSON();
		// Inicializamos el id para los test
		int id = 0;
		for (Pregunta pregunta : listaPreguntasApi) {
			id++;
			// Mapeamos Preguntas
			PreguntaTest getPregunta = new PreguntaTest(id, pregunta.getTexto(), pregunta.isEsSeleccion());
			getTest.add(getPregunta);

			for (Respuesta respuesta : pregunta.listaRespuesta) {
				// Mapeamos Respuesta
				RespuestaTest getRespuesta = new RespuestaTest(respuesta.getRespuesta(), respuesta.isEsCorrecta());
				getRespuesta.setIdPregunta(id);

				getPregunta.addRespuesta(getRespuesta);
			}

		}

		return getTest;
	}

	// Mapea Lista respuesta desde la api
	public List<RespuestaTest> getListaRespuestaApi() {

		Pregunta[] listaPreguntasApi = api.obtenerJSON();

		List<RespuestaTest> getListaRespuesta = new ArrayList<>();
		RespuestaTest getRespuesta = new RespuestaTest();
		int id = 0;
		for (Pregunta pregunta : listaPreguntasApi) {
			id++;

			for (Respuesta respuesta : pregunta.listaRespuesta) {

				getRespuesta = new RespuestaTest();
				getRespuesta.setRespuesta(respuesta.getRespuesta());
				getRespuesta.setIdPregunta(id);
				getRespuesta.setEsCorrecta(respuesta.isEsCorrecta());

				getListaRespuesta.add(getRespuesta);
			}
		}
		return getListaRespuesta;
	}

	public List<PreguntaTest> getTestBD() {

		List<PreguntaTest> test = new ArrayList<>();
		try {
			XPathQueryService service = repo.obtenerServicioXPath();

			// Consulta a lanzar
			String pathXML = "doc('Documentos/test1.xml')/xml";

			// XPathQueryService service = obtenerServicioXPath();
			ResourceSet result = service.query(pathXML);
			result = repo.queryDB(pathXML);

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

	// Generador etiquetas de pregunta
	public String etiquetarPreguta(PreguntaTest pregunta) {
		String etiqueta = "<pregunta es_multiple=\"" + pregunta.isEsMultiple() + "\">" + pregunta.getPregunta();

		return etiqueta;
	}

	// Generador etiquetas de respuesta
	public String etiquetarRespuesta(RespuestaTest respuesta, int idPregunta) {
		String etiqueta = "<respuesta id_pregunta=\"" + idPregunta + "\">" + respuesta.getRespuesta() + "<es_correcta>"
				+ respuesta.isEsCorrecta() + "</es_correcta></respuesta>";
		return etiqueta;
	}

	public String testXML() {
		List<PreguntaTest> listaPregunta = getTestFromApi();
		List<RespuestaTest> listaRespuesta = getListaRespuestaApi();
		String documento = "<documento>";

		for (PreguntaTest pregunta : listaPregunta) {

			documento += "<test id=\"" + pregunta.getIdentificador() + "\">";
			documento += etiquetarPreguta(pregunta);

			for (RespuestaTest respuesta : listaRespuesta) {
				documento += etiquetarRespuesta(respuesta, pregunta.getIdentificador());
			}
			documento += "</pregunta></test>";
		}
		documento += "</documento>";
		return documento;
	}

	public String insertar() {

		try {

			String query = "update insert " + testXML() + " into doc('Documentos/test2.xml')/xml";

			XPathQueryService service = repo.obtenerServicioXPath();
			service.query(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "OK";
	}

}
