package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Instructor;
import smu.mcda5540.fitnessbooking.entity.Person;
import smu.mcda5540.fitnessbooking.service_interface.InstructorService;
import smu.mcda5540.fitnessbooking.service_interface.PersonService;
import smu.mcda5540.fitnessbooking.utils.ConstraintViolationInfo;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.List;

@RequestMapping(value = "/data/instructors")
@CrossOrigin
@RestController
public class InstructorController {
    private final InstructorService instructorService;
    private final PersonService personService;

    @Autowired
    public InstructorController(InstructorService instructorService, PersonService personService) {
        this.instructorService = instructorService;
        this.personService = personService;
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
        if (createdInstructor.getBio() == null && createdInstructor.getBusinessPhone() == null) {
            Person person = new Person();
            try {
                person.setEmail(createdInstructor.getEmail());
                person.setUsername(createdInstructor.getUsername());
                person.setPassword(createdInstructor.getPassword());
                person.setFirstName(createdInstructor.getFirstName());
                person.setLastName(createdInstructor.getLastName());
                int personId = personService.createPerson(person);
                return new ResponseEntity<>(personId, HttpStatus.CREATED);
            } catch (DataIntegrityViolationException e) {
                String violatedAttribute=ConstraintViolationInfo.getViolatedAttribute(e.getMessage(),person,person.getClass().getSimpleName());
                throw new FitnessBookingException("Unique constraint violated for: "+violatedAttribute);
            }
        } else {
            try {
                int instructorId = instructorService.createInstructor(createdInstructor);
                return new ResponseEntity<>(instructorId, HttpStatus.CREATED);
            } catch (DataIntegrityViolationException e) {
                String violatedAttribute=ConstraintViolationInfo.getViolatedAttribute(e.getMessage(),createdInstructor,createdInstructor.getClass().getSimpleName());
                throw new FitnessBookingException("Unique constraint violated for: "+violatedAttribute);
            }
        }
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