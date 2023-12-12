package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Person;
import smu.mcda5540.fitnessbooking.repository.PersonRepository;
import smu.mcda5540.fitnessbooking.service_interface.PersonService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        Iterable<Person> iterable = personRepository.findAll();
        List<Person> persons = new ArrayList<>();
        for (Person person : iterable) {
            persons.add(person);
        }
        return persons;
    }

    @Override
    public Person getPerson(int personId) throws Exception {
        return personRepository.findById(personId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
    }

    @Override
    public int createPerson(Person createdPerson) {
        return personRepository.save(createdPerson).getPersonId();
    }

    @Override
    public Person updatePerson(int personId, Person updatedPerson) throws Exception {
        Person person = personRepository.findById(personId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        for(Field f:updatedPerson.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if(f.get(updatedPerson)!=null && f.getName()!="personId") {
                f.set(person, f.get(updatedPerson));
            }
            f.setAccessible(false);
        }
        return personRepository.save(person);
    }

    @Override
    public Person deletePerson(int personId) throws Exception {
        Person person = personRepository.findById(personId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        personRepository.deleteById(personId);
        return person;
    }
}