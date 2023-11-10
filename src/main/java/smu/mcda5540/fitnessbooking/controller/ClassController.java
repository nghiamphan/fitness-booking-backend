package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Class;
import smu.mcda5540.fitnessbooking.service_interface.ClassService;

import java.util.List;

@RequestMapping(value = "/data")
@CrossOrigin
@RestController
public class ClassController {
    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(value = "/classes")
    public ResponseEntity<List<Class>> getClasses() throws Exception {
        List<Class> classes = classService.getClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping(value = "/classes/{classId}")
    public ResponseEntity<Class> getClassById(@PathVariable int classId) throws Exception {
        Class c = classService.getClassById(classId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value = "/instructors/{instructorId}/classes")
    public ResponseEntity<List<Class>> getClassByInstructorId(@PathVariable int instructorId) throws Exception {
        List<Class> classes = classService.getClassByInstructorId(instructorId);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping(value = "/programs/{programId}/classes")
    public ResponseEntity<List<Class>> getClassByProgramId(@PathVariable int programId) throws Exception {
        List<Class> classes = classService.getClassByProgramId(programId);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PostMapping(value = "/classes")
    public ResponseEntity<Integer> createClass(@RequestBody Class createdClass) throws Exception {
        int classId = classService.createClass(createdClass);
        return new ResponseEntity<>(classId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/classes/{classId}")
    public ResponseEntity<Class> updateClass(@PathVariable int classId, @RequestBody Class updatedClass) throws Exception {
        Class c = classService.updateClass(classId, updatedClass);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping(value = "/classes/{classId}")
    public ResponseEntity<Class> deleteClass(@PathVariable int classId) throws Exception {
        Class c = classService.deleteClass(classId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}