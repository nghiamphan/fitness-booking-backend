package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Program;
import smu.mcda5540.fitnessbooking.service_interface.ProgramService;

import java.util.List;

@RequestMapping(value = "/data/programs")
@CrossOrigin
@RestController
public class ProgramController {
    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Program>> getPrograms() throws Exception {
        List<Program> programs = programService.getPrograms();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    @GetMapping(value = "/{programId}")
    public ResponseEntity<Program> getProgram(@PathVariable int programId) throws Exception {
        Program program = programService.getProgram(programId);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Integer> createProgram(@RequestBody Program createdProgram) throws Exception {
        int programId = programService.createProgram(createdProgram);
        return new ResponseEntity<>(programId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{programId}")
    public ResponseEntity<Program> updateProgram(@PathVariable int programId, @RequestBody Program updatedProgram) throws Exception {
        Program program = programService.updateProgram(programId, updatedProgram);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{programId}")
    public ResponseEntity<Program> deleteProgram(@PathVariable int programId) throws Exception {
        Program program = programService.deleteProgram(programId);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }
}