package com.shubham.crudSpringBootDemo.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.crudSpringBootDemo.Entity.Student;
import com.shubham.crudSpringBootDemo.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // create a api -> save()

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
       // return ResponseEntity.ok(createdStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        // return ResponseEntity.status(201).body(createdStudent);
    }


    // read all -> findAll()

}
