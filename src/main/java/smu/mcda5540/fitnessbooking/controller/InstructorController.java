package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Instructor;
import smu.mcda5540.fitnessbooking.service_interface.InstructorService;

import java.util.List;

@RequestMapping(value = "/data/instructors")
@CrossOrigin
@RestController
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Instructor>> getInstructors() throws Exception {
        List<Instructor> instructors = instructorService.getInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping(value = "/{instructorId}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable int instructorId) throws Exception {
        Instructor instructor = instructorService.getInstructor(instructorId);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Integer> createInstructor(@RequestBody Instructor createdInstructor) throws Exception {
        int instructorId = instructorService.createInstructor(createdInstructor);
        return new ResponseEntity<>(instructorId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable int instructorId, @RequestBody Instructor updatedInstructor) throws Exception {
        Instructor instructor = instructorService.updateInstructor(instructorId, updatedInstructor);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{instructorId}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable int instructorId) throws Exception {
        Instructor instructor = instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }
}