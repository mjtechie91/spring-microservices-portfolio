package com.pm.patientservice.controller;


import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.service.PatientService;
import com.pm.patientservice.validations.CreatePatientValidation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
//http://localhost:4000/patients
@Tag(name = "Patient", description = "API for Patient Management")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){

        List<PatientResponseDTO> patientResponseDTOS = patientService.getPatients();
        return ResponseEntity.ok().body(patientResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> storePatient(@Validated({CreatePatientValidation.class}) @RequestBody PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        return ResponseEntity.ok().body(patientService.save(patientRequestDTO));
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID patientId, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException, PatientNotFoundException {
        return ResponseEntity.ok().body(patientService.update(patientId, patientRequestDTO));
    }

    @DeleteMapping("/{patientId}")
    @Operation(summary = "Delete Patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID patientId) throws PatientNotFoundException {
        patientService.delete(patientId);
        return ResponseEntity.noContent().build();
    }
}
