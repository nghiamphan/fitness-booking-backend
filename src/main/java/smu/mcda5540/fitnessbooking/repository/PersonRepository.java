package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smu.mcda5540.fitnessbooking.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query("SELECT p FROM Person p WHERE p.username = :username AND p.password = :password")
    Person getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}