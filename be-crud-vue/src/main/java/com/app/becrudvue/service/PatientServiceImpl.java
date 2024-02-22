package com.app.becrudvue.service;

import com.app.becrudvue.enity.Patient;
import com.app.becrudvue.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    @Override
    public Patient add(Patient patient) {
        log.info("add patient = [{}]",patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient getById(Long id) {
        log.info("get by id patient = [{}]",id);
        return patientRepository.findById(id)
                .orElse(new Patient());
    }

    @Override
    public List<Patient> list() {
        List<Patient> list = patientRepository.findAll();
        log.info("size data patient = [{}]",list.size());
        return list;
    }

    @Override
    public boolean delete(Long id) {
        log.info("delete patient by id = [{}]",id);
        patientRepository.findById(id)
                .ifPresent(patientRepository::delete);
        return true;
    }
}
