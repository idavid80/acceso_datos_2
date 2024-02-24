package com.evaluacion.acceso_datos.repository;

import java.io.StringReader;

import org.springframework.stereotype.Repository;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;

import com.evaluacion.acceso_datos.entities.PreguntaTest;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

@Repository
public class RepositoryXML {

	private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/";

	public XPathQueryService obtenerServicioXPath() throws Exception {

		String driver = "org.exist.xmldb.DatabaseImpl"; // Driver

		@SuppressWarnings("rawtypes")
		Class cl = Class.forName(driver);// Cargar el driver

		@SuppressWarnings("deprecation")
		Database database = (Database) cl.newInstance(); // Instancia de la BD
		database.setProperty("create-database", "true");
		DatabaseManager.registerDatabase(database); // Registrar la BD
		// Accedemos a la colección
		Collection col = DatabaseManager.getCollection(URI + "db/", "admin", "");

		XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
		service.setProperty("pretty", "true");
		service.setProperty("encoding", "ISO-8859-1");

		return service;
	}

	// Obtener Modelo XML
	public PreguntaTest obtenerDocumento(String xml) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(PreguntaTest.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(xml);

		// System.out.println("unmarshaller: " + unmarshaller);
		return (PreguntaTest) unmarshaller.unmarshal(reader);

	}

	public ResourceSet queryDB(String query) throws Exception {
		XPathQueryService service = obtenerServicioXPath();
		ResourceSet result = service.query(query);
		return result;
	}
}
