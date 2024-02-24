package com.evaluacion.acceso_datos.service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.evaluacion.acceso_datos.entities.Alumno;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Service
public class ServiceJasper {

	// generador de informe
	public boolean generarInforme(List<Alumno> lista) {
		long nowMillis = System.currentTimeMillis();

		// Nombre del archivo creado
		String path = "./db/";
		String nombreFichero = "test " + nowMillis + ".pdf";

		Map<String, Object> empParams = new HashMap<String, Object>();
		empParams.put("title", "Informe Alumnos");
		JasperPrint empReport;
		try {
			empReport = JasperFillManager.fillReport(
					JasperCompileManager.compileReport(ResourceUtils.getFile("db/Prueba_A4.jrxml").getAbsolutePath()),
					empParams, new JRBeanCollectionDataSource(lista));

			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(empReport));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path + nombreFichero));

			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("David Dominguez");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}

		return true;
	}
}