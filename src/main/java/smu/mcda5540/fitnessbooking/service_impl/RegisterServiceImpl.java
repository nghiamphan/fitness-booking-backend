package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Register;
import smu.mcda5540.fitnessbooking.repository.RegisterRepository;
import smu.mcda5540.fitnessbooking.service_interface.RegisterService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public List<Register> getRegisters() {
        Iterable<Register> iterable = registerRepository.findAll();
        List<Register> registers = new ArrayList<>();
        for (Register register : iterable) {
            registers.add(register);
        }
        return registers;
    }

    @Override
    public List<Register> getRegisterByPersonId(int personId) {
        return registerRepository.getRegisterByPersonId(personId);
    }

    @Override
    public List<Register> getRegisterByClassId(int classId) {
        return registerRepository.getRegisterByClassId(classId);
    }

    @Override
    public int createRegister(Register register) {
        return registerRepository.save(register).getId();
    }

    @Override
    public Register deleteRegister(int registerId) throws Exception {
        Register register = registerRepository.findById(registerId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        registerRepository.delete(register);
        return register;
    }
}