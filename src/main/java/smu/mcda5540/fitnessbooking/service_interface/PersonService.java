package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Person;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.List;

public interface PersonService {
    List<Person> getPersons() throws Exception;

    Person getPerson(int personId) throws Exception;

    int createPerson(Person createdPerson) throws Exception;

    Person updatePerson(int personId, Person updatedPerson) throws Exception;

    Person deletePerson(int personId) throws Exception;

    Person dropClass(int personId, List<Integer> classIds) throws FitnessBookingException;
}