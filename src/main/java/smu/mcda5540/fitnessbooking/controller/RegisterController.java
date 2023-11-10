package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Register;
import smu.mcda5540.fitnessbooking.service_interface.RegisterService;

import java.util.List;

@RequestMapping(value = "/data")
@CrossOrigin
@RestController
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping(value = "/registers")
    public ResponseEntity<List<Register>> getRegisters() throws Exception {
        List<Register> registers = registerService.getRegisters();
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{personId}/registers")
    public ResponseEntity<List<Register>> getRegisterByPersonId(@PathVariable int personId) throws Exception {
        List<Register> registers = registerService.getRegisterByPersonId(personId);
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @GetMapping(value = "/classes/{classId}/registers")
    public ResponseEntity<List<Register>> getRegisterByClassId(@PathVariable int classId) throws Exception {
        List<Register> registers = registerService.getRegisterByClassId(classId);
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @PostMapping(value = "/registers")
    public ResponseEntity<Integer> createRegister(@RequestBody Register createdRegister) throws Exception {
        int registerId = registerService.createRegister(createdRegister);
        return new ResponseEntity<>(registerId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/registers/{registerId}")
    public ResponseEntity<Register> deleteRegister(@PathVariable int registerId) throws Exception {
        Register register = registerService.deleteRegister(registerId);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }
}