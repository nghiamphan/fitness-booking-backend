package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Class;
import smu.mcda5540.fitnessbooking.repository.ClassRepository;
import smu.mcda5540.fitnessbooking.service_interface.ClassService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> getClasses() {
        Iterable<Class> iterable = classRepository.findAll();
        List<Class> classes = new ArrayList<>();
        for (Class c : iterable) {
            classes.add(c);
        }
        return classes;
    }

    @Override
    public Class getClassById(int classId) throws Exception {
        return classRepository.findById(classId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
    }

    @Override
    public List<Class> getClassByInstructorId(int instructorId) {
        return classRepository.getClassByInstructorId(instructorId);
    }

    @Override
    public List<Class> getClassByProgramId(int programId) {
        return classRepository.getClassByProgramId(programId);
    }

    @Override
    public int createClass(Class createdClass) {
        return classRepository.save(createdClass).getId();
    }

    @Override
    public Class updateClass(int classId, Class updatedClass) throws Exception {
        Class c = classRepository.findById(classId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));

        c.setStartTime(updatedClass.getStartTime());
        c.setEndTime(updatedClass.getEndTime());
        c.setAvailableSpace(updatedClass.getAvailableSpace());
        c.setInstructor(updatedClass.getInstructor());
        c.setProgram(updatedClass.getProgram());
        c.setLocation(updatedClass.getLocation());

        return c;
    }

    @Override
    public Class deleteClass(int classId) throws Exception {
        Class c = classRepository.findById(classId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        classRepository.deleteById(classId);
        return c;
    }
}