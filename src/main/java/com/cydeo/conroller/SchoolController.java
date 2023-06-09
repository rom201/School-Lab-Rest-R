package com.cydeo.conroller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    private final AddressService addressService;


    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;

        this.addressService = addressService;
    }

    //write a method for teachers and return list of teachers

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){

        List<TeacherDTO> teacherDTOS = teacherService.findAll();

        return teacherDTOS;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){

        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved",
                studentService.findAll()));

    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent","Returned")
                .body(new ResponseWrapper(true,"Parents are here", HttpStatus.ACCEPTED.value(), parentService.findAll()));


    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressById(@PathVariable("id") Long id) throws Exception {

        return ResponseEntity.ok(new ResponseWrapper("Address ID"+id+" is retreived", addressService.findById(id)));

    }






}
