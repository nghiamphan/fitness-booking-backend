package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Qualification;
import smu.mcda5540.fitnessbooking.repository.QualificationRepository;
import smu.mcda5540.fitnessbooking.service_interface.QualificationService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository qualificationRepository;

    @Autowired
    public QualificationServiceImpl(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<Qualification> getQualifications() {
        Iterable<Qualification> iterable = qualificationRepository.findAll();
        List<Qualification> qualifications = new ArrayList<>();
        for (Qualification qualification : iterable) {
            qualifications.add(qualification);
        }
        return qualifications;
    }

    @Override
    public List<Qualification> getQualificationsByInstructorId(int instructorId) {
        return qualificationRepository.getQualificationByInstructorId(instructorId);
    }

    @Override
    public List<Qualification> getQualificationByProgramId(int programId) {
        return qualificationRepository.getQualificationByProgramId(programId);
    }

    @Override
    public int createQualification(Qualification createdQualification) {
        return qualificationRepository.save(createdQualification).getId();
    }

    @Override
    public Qualification deleteQualification(int qualificationId) throws Exception {
        Qualification qualification = qualificationRepository.findById(qualificationId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        qualificationRepository.deleteById(qualificationId);
        return qualification;
    }
}