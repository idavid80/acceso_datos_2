package com.evaluacion.acceso_datos.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.evaluacion.acceso_datos.entities.Alumno;
import com.evaluacion.acceso_datos.entities.AlumnoRepor;

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
public class ServiceJasperGuilla {
	
	private Long id;
	private String nombre;

	private String curso;

	List<String> asignaturas = new ArrayList<>();
	private List<AlumnoRepor> obtenerAlumno() {
		AlumnoRepor alumno = new AlumnoRepor();
		List<AlumnoRepor> lista = new ArrayList<AlumnoRepor>();
		List<String> listaAsignatura = new ArrayList<String>();
		
		listaAsignatura.add("Prueba");
		listaAsignatura.add("Uno");
		alumno.setNombre("Juan");
		alumno.setCurso("Dam");
		alumno.setAsignaturas(listaAsignatura);
		lista.add(alumno);
		
		listaAsignatura.add("Prueba2");
		listaAsignatura.add("Dos");
		alumno.setNombre("Pepe");
		alumno.setCurso("Daw");
		alumno.setAsignaturas(listaAsignatura);
		
		lista.add(alumno);

		


		return lista;
	}

	public boolean generarInforme(List<Alumno> lista) {
		long nowMillis = System.currentTimeMillis();
        String nombreFichero = "test " + nowMillis + ".pdf";
		
//        List<AlumnoRepor> lista = obtenerAlumno();
        
 //       System.out.print(lista.get(0).getNombre() +" y " + lista.get(1).getNombre());
		
		Map<String, Object> empParams = new HashMap<String, Object>();
		empParams.put("title", "Informe Alumnos");
		JasperPrint empReport;
		try {
			empReport = JasperFillManager.fillReport(
							JasperCompileManager.compileReport(
									ResourceUtils.getFile("db/Prueba_A4.jrxml").getAbsolutePath()),
							empParams, 
							new JRBeanCollectionDataSource(lista)
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