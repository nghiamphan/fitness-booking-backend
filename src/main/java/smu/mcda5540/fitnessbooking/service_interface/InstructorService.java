package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getInstructors() throws Exception;

    Instructor getInstructor(int instructorId) throws Exception;

    int createInstructor(Instructor createdInstructor) throws Exception;

    Instructor updateInstructor(int instructorId, Instructor updatedInstructor) throws Exception;

    Instructor deleteInstructor(int instructorId) throws Exception;
}