package org.craniogenix.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.craniogenix.model.PatientRecord;
import org.craniogenix.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientRecordController {
    private final PatientRecordRepository patientRecordRepository;
    private final ObjectMapper objectMapper; // Manual JSON Mapper

    @Autowired
    public PatientRecordController(PatientRecordRepository patientRecordRepository) {
        this.patientRecordRepository = patientRecordRepository;
        this.objectMapper = new ObjectMapper();
    }
    @PatchMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePatientByName(@RequestParam String name, @RequestBody Map<String, Object> updates) throws JsonProcessingException {
        Optional<PatientRecord> optionalPatient = patientRecordRepository.findByName(name);
        if (!optionalPatient.isPresent()) {
            return ResponseEntity.status(404).body("{\"error\": \"Patient not found\"}");
        }

        PatientRecord patient = optionalPatient.get();

        // Dynamically update fields
        updates.forEach((key, value) -> {
            switch (key) {
                case "name": patient.setName((String) value); break;
                case "age": patient.setAge((Integer) value); break;
                case "gender": patient.setGender((String) value); break;
                case "height": patient.setHeight((Integer) value); break;
                case "weight": patient.setWeight((Integer) value); break;
                case "bmi": patient.setBmi((Double) value); break;
                case "bloodPressureSystolic": patient.setBloodPressureSystolic((Integer) value); break;
                case "bloodPressureDiastolic": patient.setBloodPressureDiastolic((Integer) value); break;
                case "glucoseLevel": patient.setGlucoseLevel((Integer) value); break;
                case "cholesterolLevel": patient.setCholesterolLevel((Integer) value); break;
                case "smokingStatus": patient.setSmokingStatus((String) value); break;
                case "alcoholConsumption": patient.setAlcoholConsumption((String) value); break;
                case "physicalActivity": patient.setPhysicalActivity((String) value); break;
                case "comorbidities": patient.setComorbidities((List<String>) value); break;
                case "familyHistory": patient.setFamilyHistory((String) value); break;
                case "medicationHistory": patient.setMedicationHistory((String) value); break;
                case "hasTumor": patient.setHasTumor((Boolean) value); break;
            }
        });

        PatientRecord updatedPatient = patientRecordRepository.save(patient);
        return ResponseEntity.ok(objectMapper.writeValueAsString(updatedPatient));
    }
    // Get All Patients
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllPatients() throws JsonProcessingException {
        List<PatientRecord> patients = patientRecordRepository.findAll();
        String json = objectMapper.writeValueAsString(patients);
        System.out.println("Serialized JSON: " + json);
        return ResponseEntity.ok(json);
    }

    // Get Patient By ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPatientById(@PathVariable String id) throws JsonProcessingException {
        Optional<PatientRecord> patient = patientRecordRepository.findById(id);
        if (patient.isPresent()) {
            String json = objectMapper.writeValueAsString(patient.get());
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(404).body("{\"error\": \"Patient not found\"}");
    }

    // Search Patient by Name
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPatientByName(@RequestParam String name) throws JsonProcessingException {
        Optional<PatientRecord> patient = patientRecordRepository.findByName(name);
        if (patient.isPresent()) {
            String json = objectMapper.writeValueAsString(patient.get());
            return ResponseEntity.ok(json);
        }
        return ResponseEntity.status(404).body("{\"error\": \"Patient not found\"}");
    }

    // Create a Patient Record
    @PostMapping(value = "/create-record", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPatient(@RequestBody PatientRecord patient) throws JsonProcessingException {
        PatientRecord savedPatient = patientRecordRepository.save(patient);
        String json = objectMapper.writeValueAsString(savedPatient);
        return ResponseEntity.ok(json);
    }

    // Delete Patient By ID
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePatient(@PathVariable String id) throws JsonProcessingException {
        if (patientRecordRepository.existsById(id)) {
            patientRecordRepository.deleteById(id);
            return ResponseEntity.ok("{\"message\": \"Patient deleted successfully\"}");
        }
        return ResponseEntity.status(404).body("{\"error\": \"Patient not found\"}");
    }

    // Delete Patient by Name
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePatientByName(@RequestParam String name) throws JsonProcessingException {
        Optional<PatientRecord> patient = patientRecordRepository.findByName(name);
        if (patient.isPresent()) {
            patientRecordRepository.deleteByName(name);
            return ResponseEntity.ok("{\"message\": \"Patient deleted successfully\"}");
        }
        return ResponseEntity.status(404).body("{\"error\": \"Patient not found\"}");
    }
}
