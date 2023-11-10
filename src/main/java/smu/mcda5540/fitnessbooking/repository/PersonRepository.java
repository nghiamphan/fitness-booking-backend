package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.repository.CrudRepository;
import smu.mcda5540.fitnessbooking.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}