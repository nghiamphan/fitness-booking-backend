package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Program;

import java.util.List;

public interface ProgramService {
    List<Program> getPrograms() throws Exception;

    Program getProgram(int programId) throws Exception;

    int createProgram(Program createdProgram) throws Exception;

    Program updateProgram(int programId, Program updatedProgram) throws Exception;

    Program deleteProgram(int programId) throws Exception;
}