package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Instructor;
import smu.mcda5540.fitnessbooking.entity.Person;
import smu.mcda5540.fitnessbooking.repository.InstructorRepository;
import smu.mcda5540.fitnessbooking.repository.PersonRepository;
import smu.mcda5540.fitnessbooking.service_interface.LoginService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    private final PersonRepository personRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public LoginServiceImpl(PersonRepository personRepository, InstructorRepository instructorRepository) {
        this.personRepository = personRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Object login(String username, String password) throws Exception {
        Person person = personRepository.getUserByUsernameAndPassword(username, password);
        if (person == null) {
            throw new FitnessBookingException("ERROR.INVALID_CREDENTIALS");
        }

        Instructor instructor = instructorRepository.getInstructorByPersonId(person.getPersonId());

        return Objects.requireNonNullElse(instructor, person);
    }
}