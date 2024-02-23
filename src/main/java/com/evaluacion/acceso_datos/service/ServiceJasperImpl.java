package com.evaluacion.acceso_datos.service;
/*
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.acceso_datos.Utils.AlumnoGenerator;
import com.evaluacion.acceso_datos.entities.AlumnoRepor;
import com.evaluacion.acceso_datos.repository.RepositoryJasper;

import net.sf.jasperreports.engine.JRException;

@Service
public class ServiceJasperImpl implements ServiceJasper {

    private RepositoryJasper petRepository;


    private AlumnoGenerator petReportGenerator;

    @Override
    public List<AlumnoRepor> findAll() {
        return petRepository.findAll();
    }

    @Override
    public AlumnoRepor findById(Long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public AlumnoRepor save(AlumnoRepor pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return petReportGenerator.exportToPdf(petRepository.findAll());
    }

    @Override
    public byte[] exportXls() throws JRException, FileNotFoundException {
        return petReportGenerator.exportToXls(petRepository.findAll());
    }
}

*/