package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.repository.CrudRepository;
import smu.mcda5540.fitnessbooking.entity.Program;

public interface ProgramRepository extends CrudRepository<Program, Integer> {
}