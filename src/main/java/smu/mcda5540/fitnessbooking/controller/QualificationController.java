package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Qualification;
import smu.mcda5540.fitnessbooking.service_interface.QualificationService;

import java.util.List;

@RequestMapping(value = "/data")
@CrossOrigin
@RestController
public class QualificationController {
    private final QualificationService qualificationService;

    @Autowired
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping(value = "/qualifications")
    public ResponseEntity<List<Qualification>> getQualifications() throws Exception {
        List<Qualification> qualifications = qualificationService.getQualifications();
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @GetMapping(value = "/instructors/{instructorId}/qualifications")
    public ResponseEntity<List<Qualification>> getQualificationByInstructorId(@PathVariable int instructorId) throws Exception {
        List<Qualification> qualifications = qualificationService.getQualificationsByInstructorId(instructorId);
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @GetMapping(value = "/programs/{programId}/qualifications")
    public ResponseEntity<List<Qualification>> getQualificationByProgramId(@PathVariable int programId) throws Exception {
        List<Qualification> qualifications = qualificationService.getQualificationByProgramId(programId);
        return new ResponseEntity<>(qualifications, HttpStatus.OK);
    }

    @PostMapping(value = "/qualifications")
    public ResponseEntity<Integer> createQualification(@RequestBody Qualification createdQualification) throws Exception {
        int qualificationId = qualificationService.createQualification(createdQualification);
        return new ResponseEntity<>(qualificationId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/qualifications/{qualificationId}")
    public ResponseEntity<Qualification> deleteQualification(@PathVariable int qualificationId) throws Exception {
        Qualification qualification = qualificationService.deleteQualification(qualificationId);
        return new ResponseEntity<>(qualification, HttpStatus.OK);
    }
}