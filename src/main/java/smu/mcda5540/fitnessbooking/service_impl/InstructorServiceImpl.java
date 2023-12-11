package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Instructor;
import smu.mcda5540.fitnessbooking.repository.InstructorRepository;
import smu.mcda5540.fitnessbooking.service_interface.InstructorService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getInstructors() {
        Iterable<Instructor> iterable = instructorRepository.findAll();
        List<Instructor> instructors = new ArrayList<>();
        for (Instructor instructor : iterable) {
            instructors.add(instructor);
        }
        return instructors;
    }

    @Override
    public Instructor getInstructor(int instructorId) throws Exception {
        return instructorRepository.findById(instructorId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
    }

    @Override
    public int createInstructor(Instructor createdInstructor) {
        return instructorRepository.save((createdInstructor)).getPersonId();
    }

    @Override
    public Instructor updateInstructor(int instructorId, Instructor updatedInstructor) throws Exception {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));

        instructor.setBio(updatedInstructor.getBio());
        instructor.setBusinessPhone(updatedInstructor.getBusinessPhone());

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor deleteInstructor(int instructorId) throws Exception {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        instructorRepository.deleteById(instructorId);
        return instructor;
    }
}