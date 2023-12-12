package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smu.mcda5540.fitnessbooking.entity.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.personId = :personId")
    Instructor getInstructorByPersonId(@Param("personId") int personId);
}