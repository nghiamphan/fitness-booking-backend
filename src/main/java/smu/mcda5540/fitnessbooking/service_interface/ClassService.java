package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Class;

import java.util.List;

public interface ClassService {
    List<Class> getClasses() throws Exception;

    Class getClassById(int classId) throws Exception;

    List<Class> getClassByInstructorId(int instructorId) throws Exception;

    List<Class> getClassByProgramId(int programId) throws Exception;

    int createClass(Class createdClass) throws Exception;

    Class updateClass(int classId, Class updatedClass) throws Exception;

    Class deleteClass(int classId) throws Exception;
}