package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smu.mcda5540.fitnessbooking.entity.Register;

import java.util.List;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
    @Query("SELECT r FROM Register r WHERE r.mClass.id = :classId AND r.person.id = :personId")
    Register getRegisterByClassIdAndPersonId(@Param("classId") int classId, @Param("personId") int personId);

    @Query("SELECT r FROM Register r WHERE r.mClass.id = :classId")
    List<Register> getRegisterByClassId(@Param("classId") int classId);

    @Query("SELECT r FROM Register r WHERE r.person.id = :personId")
    List<Register> getRegisterByPersonId(@Param("personId") int personId);
}