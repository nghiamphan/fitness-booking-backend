package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Person;
import smu.mcda5540.fitnessbooking.service_interface.PersonService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.List;

@RequestMapping(value = "/data/persons")
@CrossOrigin
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Person>> getPersons() throws Exception {
        List<Person> persons = personService.getPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable int personId) throws Exception {
        Person person = personService.getPerson(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Integer> createPerson(@RequestBody Person createdPerson) throws Exception {
        int personId = personService.createPerson(createdPerson);
        return new ResponseEntity<>(personId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable int personId, @RequestBody Person updatedPerson) throws Exception {
        Person person = personService.updatePerson(personId, updatedPerson);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/drop-class/{personId}")
    public ResponseEntity<Person> dropClass(@PathVariable int personId, @RequestParam List<Integer> classes) throws FitnessBookingException {
        Person person = personService.dropClass(personId, classes);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<Person> deletePerson(@PathVariable int personId) throws Exception {
        Person person = personService.deletePerson(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}