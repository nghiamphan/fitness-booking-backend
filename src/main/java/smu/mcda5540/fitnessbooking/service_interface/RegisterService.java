package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Register;

import java.util.List;

public interface RegisterService {
    List<Register> getRegisters() throws Exception;

    List<Register> getRegisterByPersonId(int personId) throws Exception;

    List<Register> getRegisterByClassId(int classId) throws Exception;

    int createRegister(Register register) throws Exception;

    Register deleteRegister(int registerId) throws Exception;
}