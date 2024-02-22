package com.app.becrudvue.service;

import com.app.becrudvue.enity.Patient;


import java.util.List;


public interface PatientService {

    public Patient add(Patient patient);
    public Patient getById(Long id);

    public List<Patient> list();
    boolean delete(Long id);
}
