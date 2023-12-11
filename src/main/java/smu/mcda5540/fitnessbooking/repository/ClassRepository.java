package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smu.mcda5540.fitnessbooking.entity.Class;

import java.util.List;

public interface ClassRepository extends CrudRepository<Class, Integer> {
    @Query("SELECT c FROM Class c WHERE c.instructor.personId = :instructorId")
    List<Class> getClassByInstructorId(@Param("instructorId") int instructorId);

    @Query("SELECT c FROM Class c WHERE c.program.programId = :programId")
    List<Class> getClassByProgramId(@Param("programId") int programId);
}