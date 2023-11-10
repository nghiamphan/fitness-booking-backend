package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Program;
import smu.mcda5540.fitnessbooking.repository.ProgramRepository;
import smu.mcda5540.fitnessbooking.service_interface.ProgramService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public List<Program> getPrograms() {
        Iterable<Program> iterable = programRepository.findAll();
        List<Program> programs = new ArrayList<>();
        for (Program program : iterable) {
            programs.add(program);
        }
        return programs;
    }

    @Override
    public Program getProgram(int programId) throws Exception {
        return programRepository.findById(programId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
    }

    @Override
    public int createProgram(Program createdProgram) {
        return programRepository.save((createdProgram)).getId();
    }

    @Override
    public Program updateProgram(int programId, Program updatedProgram) throws Exception {
        Program program = programRepository.findById(programId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));

        program.setName(updatedProgram.getName());
        program.setDescription(updatedProgram.getDescription());

        return programRepository.save(program);
    }

    @Override
    public Program deleteProgram(int programId) throws Exception {
        Program program = programRepository.findById(programId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        programRepository.deleteById(programId);
        return program;
    }
}