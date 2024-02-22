package com.evaluacion.acceso_datos.service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.evaluacion.acceso_datos.collection.Estudiante;

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

	public boolean generarInforme(List<Estudiante> listaEstudiantes) {
		long nowMillis = System.currentTimeMillis();
        String nombreFichero = "test " + nowMillis + ".pdf";
		
		
		Map<String, Object> empParams = new HashMap<String, Object>();
		empParams.put("alumnoData", "Informe de Alumnos");
		JasperPrint empReport;
		try {
			empReport = JasperFillManager.fillReport(
							JasperCompileManager.compileReport(
									ResourceUtils.getFile("target/Informe.jrxml").getAbsolutePath()),
							empParams, 
							new JRBeanCollectionDataSource(listaEstudiantes)
					);
		
			
			JRPdfExporter exporter = new JRPdfExporter();
	
			exporter.setExporterInput(new SimpleExporterInput(empReport));
			exporter.setExporterOutput(
			  new SimpleOutputStreamExporterOutput(nombreFichero));
	
			SimplePdfReportConfiguration reportConfig
			  = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);
	
			SimplePdfExporterConfiguration exportConfig
			  = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("Cesur Formaciones");
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
