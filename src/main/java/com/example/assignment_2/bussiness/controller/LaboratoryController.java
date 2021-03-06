package com.example.assignment_2.bussiness.controller;

import com.example.assignment_2.bussiness.model.DTO.AttendanceDTO;
import com.example.assignment_2.bussiness.model.DTO.LaboratoryDTO;
import com.example.assignment_2.bussiness.model.DTO.TeacherDTO;
import com.example.assignment_2.bussiness.model.base.Attendance;
import com.example.assignment_2.bussiness.model.base.Laboratory;
import com.example.assignment_2.bussiness.model.base.Teacher;
import com.example.assignment_2.bussiness.model.create.LaboratoryCreateModel;
import com.example.assignment_2.bussiness.service.implementation.LaboratoryServiceImplementation;
import com.example.assignment_2.bussiness.service.implementation.TeacherServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryServiceImplementation laboratoryService;
    @Autowired
    private TeacherServiceImplementation teacherService;


    @GetMapping("/getAll")
    public ResponseEntity<List<LaboratoryDTO>> findAll() {
        List<Laboratory> laboratories = laboratoryService.findAll();

        if (laboratories == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(laboratories.stream().map(LaboratoryDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LaboratoryDTO> findById(@PathVariable Long id) {
        Laboratory found = laboratoryService.findById(id);
        if(found == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new LaboratoryDTO(found), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LaboratoryDTO> create(@RequestBody LaboratoryCreateModel createModel, @RequestHeader("Token") String authenticationToken) {
        Teacher teacher = teacherService.findByAuthenticationToken(authenticationToken);

        if(teacher == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        Laboratory saved = laboratoryService.create(createModel);

        return new ResponseEntity<>(new LaboratoryDTO(saved), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<LaboratoryDTO> deleteById(@PathVariable Long id, @RequestHeader("Token") String authenticationToken) {
        Teacher teacher = teacherService.findByAuthenticationToken(authenticationToken);

        if(teacher == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        Laboratory deleted = laboratoryService.deleteById(id);

        if(deleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new LaboratoryDTO(deleted), HttpStatus.OK);
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<LaboratoryDTO> update(@PathVariable Long id, @RequestBody LaboratoryCreateModel newValue, @RequestHeader("Token") String authenticationToken) {
        Teacher teacher = teacherService.findByAuthenticationToken(authenticationToken);

        if(teacher == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        Laboratory updated = laboratoryService.update(id, newValue);

        if(updated == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new LaboratoryDTO(updated), HttpStatus.OK);
    }

    @GetMapping("/getAttendance/{id}")
    public ResponseEntity<List<AttendanceDTO>> getAttendance(@PathVariable Long id, @RequestHeader("Token") String authenticationToken) {
        Teacher teacher = teacherService.findByAuthenticationToken(authenticationToken);

        if(teacher == null){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        List<Attendance> attendances = laboratoryService.getAttendance(id);

        if(attendances == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(attendances.stream().map(AttendanceDTO::new).collect(Collectors.toList()), HttpStatus.OK);

    }
}
