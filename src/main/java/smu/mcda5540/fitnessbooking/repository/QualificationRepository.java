package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smu.mcda5540.fitnessbooking.entity.Qualification;

import java.util.List;

public interface QualificationRepository extends CrudRepository<Qualification, Integer> {
    @Query("SELECT q FROM Qualification q WHERE q.instructor.id = :instructorId")
    List<Qualification> getQualificationByInstructorId(@Param("instructorId") int instructorId);

    @Query("SELECT q FROM Qualification q WHERE q.program.id = :programId")
    List<Qualification> getQualificationByProgramId(@Param("programId") int programId);
}