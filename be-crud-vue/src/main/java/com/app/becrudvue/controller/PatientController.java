package com.app.becrudvue.controller;

import com.app.becrudvue.enity.Patient;
import com.app.becrudvue.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173")
@RequestMapping(value = "/api/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping(value = "/save")
    public ResponseEntity<Patient> add(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.add(patient), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Patient> get(@PathVariable("id")Long id){
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Patient>> list(){
        return new ResponseEntity<>(patientService.list(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id")Long id){
        return new ResponseEntity<>(patientService.delete(id), HttpStatus.OK);
    }
}
