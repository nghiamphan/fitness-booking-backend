package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Qualification;

import java.util.List;

public interface QualificationService {
    List<Qualification> getQualifications() throws Exception;

    List<Qualification> getQualificationsByInstructorId(int instructorId) throws Exception;

    List<Qualification> getQualificationByProgramId(int programId) throws Exception;

    int createQualification(Qualification createdQualification) throws Exception;

    Qualification deleteQualification(int qualificationId) throws Exception;
}